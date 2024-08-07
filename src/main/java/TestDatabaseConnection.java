import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/famisanar";
        String user = "postgres";
        String password = "root";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de conexión.");
        }
    }
}