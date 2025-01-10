package fr.isen.projet.apartment.implement;

import fr.isen.projet.apartment.interfaces.models.apartmentModel;
import fr.isen.projet.apartment.interfaces.models.availabilityModel;
import fr.isen.projet.apartment.interfaces.services.availabilityService;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class availabilityServiceImpl implements availabilityService{
    @Inject
    AgroalDataSource dataSource;

    @Override
    public List<availabilityModel> getAllDispo() {
        List<availabilityModel> availabilities = new ArrayList<>();
        String sql = "SELECT * FROM apartmentavailability";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                availabilityModel availabitity = new availabilityModel();
                availabitity.setId(rs.getInt("id"));
                availabitity.setAvailability(rs.getString("availability"));
                availabitity.setYear(rs.getInt("year"));
                availabilities.add(availabitity);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all addresses", e);
        }
        return availabilities;
    }

    @Override
    public availabilityModel getDispoById(int id) {
        String sql = "SELECT * FROM apartmentavailability WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    availabilityModel availability = new availabilityModel();
                    availability.setId(rs.getInt("id"));
                    availability.setAvailability(rs.getString("availability"));
                    availability.setYear(rs.getInt("year"));
                    return availability;
                } else {
                    throw new RuntimeException("Address not found for ID: " + id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching address by UUID", e);
        }
    }

    @Override
    public availabilityModel addDispo(availabilityModel dispo) {
        String sql = "INSERT INTO apartmentavailability (id, availability, year) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dispo.getId());
            stmt.setString(2, dispo.getAvailability());
            stmt.setInt(3, dispo.getYear());
            stmt.executeUpdate();
            return dispo;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating address", e);
        }
    }

    @Override
    public void removeDispo(int id) {
        String sql = "DELETE FROM apartmentavailability WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No address found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting address", e);
        }
    }

    @Override
    public availabilityModel updateDispo(int id, availabilityModel newDispo) {
        String sql = "UPDATE apartmentavailability SET availability = ?, year = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configurer les paramètres pour la requête
            stmt.setString(1, newDispo.getAvailability()); // Premier paramètre : availability
            stmt.setInt(2, newDispo.getYear()); // Deuxième paramètre : year
            stmt.setInt(3, id); // Troisième paramètre : id (pour la condition WHERE)

            // Exécuter la requête
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No availability found with ID: " + id);
            }

            return newDispo;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating apartment", e);
        }
    }

}
