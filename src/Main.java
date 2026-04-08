import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main  {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:activity.sqlite3";

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection successfully");

            Statement stmt = conn.createStatement();







        } catch (SQLException e) {
            System.out.println("Connection error");
        }





    }
}