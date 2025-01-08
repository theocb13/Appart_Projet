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
                apartment.setOwnerID(rs.getInt("owner_id"));
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
                    apartment.setOwnerID(rs.getInt("owner_id"));
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
    public apartmentModel addAppartement(apartmentModel appartement) {
        return null;
    }

    @Override
    public boolean removeAppartement(apartmentModel appartementId) {
        return false;
    }

    @Override
    public apartmentModel updateAppartement(apartmentModel newAppartement) {
        return null;
    }
}
