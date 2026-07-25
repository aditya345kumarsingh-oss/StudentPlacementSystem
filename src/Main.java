import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "@ditya2006S";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}