import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/wt_lab"; // Replace 'wt_lab' with your database name
        String user = "root"; // Default username for MySQL Workbench
        String password = "gouse47"; // Set this if you've configured a MySQL password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successful!");

            // Create a Statement
            Statement stmt = connection.createStatement();

            // Execute a Query
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);

            // Process Results
            System.out.println("Student Details:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("--------------------------");
            }

            // Close Connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
