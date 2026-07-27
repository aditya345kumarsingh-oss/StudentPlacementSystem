import java.sql.Connection;   // Used to store the database connection

public class Main {

    public static void main(String[] args) {

        // Step 1: Get connection from DBConnection class
        Connection con = DBConnection.getConnection();

        // Step 2: Check whether database connected or not
        if (con != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Database Connection Failed!");
            return;   // Stop the program if connection fails
        }

        // Step 3: Create StudentDAO object
        // We need this object because all database operations
        // (Insert, Read, Update, Delete) are inside StudentDAO.
        StudentDAO dao = new StudentDAO();

        // Step 4: Update CGPA of student whose ID is 2
        // First value = Student ID
        // Second value = New CGPA
        dao.updateStudentCGPA(2, 8.40);

        // Step 5: Display all students after update
        dao.getAllStudents();

    }
}