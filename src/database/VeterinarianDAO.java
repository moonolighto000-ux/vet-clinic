package database;

import model.Veterinarian;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAO {

    public void insert(Veterinarian vet) {

        String sql =
                "INSERT INTO veterinarian(name, specialization, experience) VALUES (?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vet.getName());
            ps.setString(2, vet.getSpecialization());
            ps.setInt(3, vet.getExperience());

            ps.executeUpdate();
            ps.close();

            System.out.println("Inserted!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
    }

    public List<Veterinarian> getAll() {

        List<Veterinarian> list = new ArrayList<>();

        String sql = "SELECT * FROM veterinarian";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veterinarian v = new Veterinarian(
                        rs.getInt("vet_id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getInt("experience")
                );
                list.add(v);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }

        return list;
    }

    public boolean update(Veterinarian vet) {

        String sql =
                "UPDATE veterinarian SET name=?, specialization=?, experience=? WHERE vet_id=?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vet.getName());
            ps.setString(2, vet.getSpecialization());
            ps.setInt(3, vet.getExperience());
            ps.setInt(4, vet.getVetId());

            int rows = ps.executeUpdate();
            ps.close();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }

        return false;
    }

    public boolean delete(int id) {

        String sql = "DELETE FROM veterinarian WHERE vet_id=?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            ps.close();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }

        return false;
    }

    public List<Veterinarian> searchByName(String name) {

        List<Veterinarian> list = new ArrayList<>();

        String sql =
                "SELECT * FROM veterinarian WHERE name ILIKE ?";

        Connection conn = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Veterinarian(
                        rs.getInt("vet_id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getInt("experience")
                ));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }

        return list;
    }

    public List<Veterinarian> getByMinExperience(int minExp) {
        List<Veterinarian> list = new ArrayList<>();
        String sql = "SELECT * FROM veterinarian WHERE experience >= ?";

        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, minExp);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Veterinarian(
                        rs.getInt("vet_id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getInt("experience")
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return list;
    }

    public List<Veterinarian> getByExperienceRange(int min, int max) {
        List<Veterinarian> list = new ArrayList<>();
        String sql = "SELECT * FROM veterinarian WHERE experience BETWEEN ? AND ?";

        Connection conn = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Veterinarian(
                        rs.getInt("vet_id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getInt("experience")
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return list;
    }
}
