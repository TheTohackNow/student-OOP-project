package database;
import gymSys.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class memberDAO {

    public void insertMember(member m) {
        String sql = "INSERT INTO member (name, is_female, phone, is_ingroup, age) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, m.getName());
            statement.setBoolean(2, m.isIs_female());
            statement.setString(3, m.getPhone_number());
            statement.setBoolean(4, m.isIn_group());
            statement.setInt(5, m.getAge());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Member inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllStaff() {
        String sql = "SELECT * FROM member";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL MEMBERS FROM DATABASE ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("member_id");
                String name = resultSet.getString("name");
                boolean is_female = resultSet.getBoolean("is_female");
                int age = resultSet.getInt("age");
                boolean is_ingroup = resultSet.getBoolean("is_ingroup");
                String phone = resultSet.getString("phone");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("is female: " + is_female);
                System.out.println("age: " + age + " years");
                System.out.println("is in group: " + is_ingroup);
                System.out.println("phone: " + phone);
                System.out.println("---");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean getMemberById(int member_id) {
        String sql = "SELECT * FROM member WHERE member_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, member_id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("\n--- MEMBER FOUND ---");
                System.out.println("ID: " + rs.getInt("member_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("is female: " + rs.getBoolean("is_female"));
                System.out.println("age: " + rs.getInt("age"));
                System.out.println("is in group: " + rs.getBoolean("is_ingroup"));
                System.out.println("phone: " + rs.getString("phone"));
                rs.close();
                statement.close();
                return true;
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean updateMember(int member_id, String name, int age, boolean is_female, String phone, boolean is_ingroup) {
        String sql = "UPDATE member SET name = ?, age = ?, is_female = ?, phone = ?, is_ingroup = ? WHERE member_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setBoolean(3, is_female);
            statement.setString(4, phone);
            statement.setBoolean(5, is_ingroup);
            statement.setInt(6, member_id);

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Member updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean deleteMember(int member_id) {
        String sql = "DELETE FROM member WHERE member_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, member_id);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("Member deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public void searchByName(String namePart) {
        String sql = "SELECT * FROM member WHERE name ILIKE ? ORDER BY member_id";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + namePart + "%");

            ResultSet rs = statement.executeQuery();
            System.out.println("\n--- SEARCH RESULT ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("member_id") + " | " +
                        rs.getString("name") + " | age: " + rs.getInt("age"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByAgeRange(int minAge, int maxAge) {
        String sql = "SELECT * FROM member WHERE age BETWEEN ? AND ? ORDER BY age DESC";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            statement.setInt(2, maxAge);

            ResultSet rs = statement.executeQuery();
            System.out.println("\n--- SEARCH RESULT ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("member_id") + " | " +
                        rs.getString("name") + " | age: " + rs.getInt("age"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
