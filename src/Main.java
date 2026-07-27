import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if(con != null) {
            System.out.println("Database Connected Successfully!");
        }
        else {
            System.out.println("Database Connection Failed!");
            return;
        }


        StudentDAO dao = new StudentDAO();

        dao.getAllStudents();

    }
}