package fr.isen.projet.apartment.implement;

import fr.isen.projet.apartment.interfaces.models.apartmentModel;
import fr.isen.projet.apartment.interfaces.services.apartmentService;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped // Ceci rend votre classe injectable en tant que bean CDI
public class apartmentServiceImpl implements apartmentService{

    @Inject
    AgroalDataSource dataSource;

    @Override
    public List<apartmentModel> getAllAppartements() {
        List<apartmentModel> apartments = new ArrayList<>();
        String sql = "SELECT * FROM apartment";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                apartmentModel apartment = new apartmentModel();
                apartment.setId(rs.getString("id"));
                apartment.setNbPieces(rs.getInt("nb_piece"));
                apartment.setPrice(rs.getInt("price"));
                apartment.setArea(rs.getInt("area"));
                apartment.setNbPeople(rs.getInt("nb_people"));
                apartment.setAddress(rs.getString("adress"));
                apartment.setUuid(rs.getString("uuid"));
                apartment.setAvailabilityID(rs.getInt("availability_id"));
                apartments.add(apartment);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all addresses", e);
        }
        return apartments;
    }

    @Override
    public apartmentModel getAppartementById(String id) {
        String sql = "SELECT * FROM apartment WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    apartmentModel apartment = new apartmentModel();
                    apartment.setId(rs.getString("id"));
                    apartment.setNbPieces(rs.getInt("nb_piece"));
                    apartment.setPrice(rs.getInt("price"));
                    apartment.setArea(rs.getInt("area"));
                    apartment.setNbPeople(rs.getInt("nb_people"));
                    apartment.setAddress(rs.getString("adress"));
                    apartment.setUuid(rs.getString("uuid"));
                    apartment.setAvailabilityID(rs.getInt("availability_id"));
                    return apartment;
                } else {
                    throw new RuntimeException("Address not found for ID: " + id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching address by UUID", e);
        }
    }

    @Override
    public apartmentModel addAppartement(apartmentModel apartement) {
        String sql = "INSERT INTO apartment (id, nb_piece, price, area, nb_people, adress, uuid, availability_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, apartement.getId());
            stmt.setInt(2, apartement.getNbPieces());
            stmt.setInt(3, apartement.getPrice());
            stmt.setInt(4, apartement.getArea());
            stmt.setInt(5, apartement.getNbPeople());
            stmt.setString(6, apartement.getAddress());
            stmt.setString(7, apartement.getUuid());
            stmt.setInt(8, apartement.getAvailabilityID());
            stmt.executeUpdate();
            return apartement;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating address", e);
        }
    }

    @Override
    public void removeAppartement(String id) {
        String sql = "DELETE FROM apartment WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No address found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting address", e);
        }
    }

    @Override
    public apartmentModel updateApartment(String id, apartmentModel apartment) {
        String sql = "UPDATE apartment SET nb_piece = ?, price = ?, area = ?, nb_people = ?, adress = ?, uuid = ?, availability_id = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configurer les paramètres pour la requête
            stmt.setInt(1, apartment.getNbPieces());
            stmt.setInt(2, apartment.getPrice());
            stmt.setInt(3, apartment.getArea());
            stmt.setInt(4, apartment.getNbPeople());
            stmt.setString(5, apartment.getAddress());
            stmt.setString(6, apartment.getUuid());
            stmt.setInt(7, apartment.getAvailabilityID());
            stmt.setString(8, id); // L'ID doit être une chaîne

            // Exécuter la requête
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No apartment found with ID: " + id);
            }

            return apartment;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating apartment", e);
        }
    }

}
