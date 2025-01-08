package fr.isen.projet.apartment.implement;

import fr.isen.projet.apartment.interfaces.models.apartmentModel;
import fr.isen.projet.apartment.interfaces.models.ownerModel;
import fr.isen.projet.apartment.interfaces.services.ownerService;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ownerServiceImpl implements ownerService{
    @Inject
    AgroalDataSource dataSource;

    @Override
    public List<ownerModel> getAllProprio() {
        List<ownerModel> owners = new ArrayList<>();
        String sql = "SELECT * FROM owner";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ownerModel owner = new ownerModel();
                owner.setUuid(rs.getString("uuid"));
                owner.setId_address(rs.getString("id_address"));
                owner.setName(rs.getString("Name"));
                owner.setFirst_name(rs.getString("First_Name"));
                owner.setEmail(rs.getString("Email"));
                owner.setPersonal_phone(rs.getString("personal_phone"));
                owner.setJob(rs.getString("job"));
                owner.setWork_phone(rs.getString("work_phone"));
                owners.add(owner);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all addresses", e);
        }
        return owners;
    }

    @Override
    public ownerModel getProprioById(String  uuid) {
        String sql = "SELECT * FROM owner WHERE uuid = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, uuid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ownerModel owner = new ownerModel();
                    owner.setUuid(rs.getString("uuid"));
                    owner.setId_address(rs.getString("id_address"));
                    owner.setName(rs.getString("Name"));
                    owner.setFirst_name(rs.getString("First_Name"));
                    owner.setEmail(rs.getString("Email"));
                    owner.setPersonal_phone(rs.getString("personal_phone"));
                    owner.setJob(rs.getString("job"));
                    owner.setWork_phone(rs.getString("work_phone"));
                    return owner;
                } else {
                    throw new RuntimeException("Address not found for UUID: " + uuid);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching address by UUID", e);
        }
    }

    @Override
    public ownerModel addProprio(ownerModel proprio) {
        String sql = "INSERT INTO owner (uuid, id_address, Name, First_Name, Email, personal_phone, job, work_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, proprio.getUuid());
            stmt.setString(2, proprio.getId_address());
            stmt.setString(3, proprio.getName());
            stmt.setString(4, proprio.getFirst_name());
            stmt.setString(5, proprio.getEmail());
            stmt.setString(6, proprio.getPersonal_phone());
            stmt.setString(7, proprio.getJob());
            stmt.setString(8, proprio.getWork_phone());
            stmt.executeUpdate();
            return proprio;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating address", e);
        }
    }

    @Override
    public void removeProprio(String  uuid) {
        String sql = "DELETE FROM owner WHERE uuid = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, uuid);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No address found with UUID: " + uuid);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting owner", e);
        }
    }

    @Override
    public ownerModel updateProprio(String uuid, ownerModel proprio) {
        String sql = "UPDATE owner SET id_address = ?, name = ?, first_name = ?, email = ?, personal_phone = ?, job = ?, work_phone = ? WHERE uuid = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, proprio.getId_address());
            stmt.setString(2, proprio.getName());
            stmt.setString(3, proprio.getFirst_name());
            stmt.setString(4, proprio.getEmail());
            stmt.setString(5, proprio.getPersonal_phone());
            stmt.setString(6, proprio.getJob());
            stmt.setString(7, proprio.getWork_phone());
            stmt.setString(8, uuid);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No owner found with UUID: " + uuid);
            }

            return proprio;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating owner", e);
        }
    }



}
