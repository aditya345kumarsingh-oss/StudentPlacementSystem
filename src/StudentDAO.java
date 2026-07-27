import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // ================= CREATE Operation =================
    public void addStudent(Student student) {

        Connection con = DBConnection.getConnection();

        String query =
        "INSERT INTO student(name,email,phone,course,branch,cgpa,passing_year) VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getBranch());
            ps.setDouble(6, student.getCgpa());
            ps.setInt(7, student.getPassingYear());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }

    // ================= READ Operation =================
    public void getAllStudents() {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM student";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nStudent List");
            System.out.println("----------------------");

            while (rs.next()) {

                System.out.println("ID : " + rs.getInt("student_id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Phone : " + rs.getString("phone"));
                System.out.println("Course : " + rs.getString("course"));
                System.out.println("Branch : " + rs.getString("branch"));
                System.out.println("CGPA : " + rs.getDouble("cgpa"));
                System.out.println("Passing Year : " + rs.getInt("passing_year"));

                System.out.println("----------------------");

            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }

    // ================= UPDATE Operation =================
    public void updateStudentCGPA(int studentId, double newCgpa) {

        Connection con = DBConnection.getConnection();

        String query =
        "UPDATE student SET cgpa = ? WHERE student_id = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, newCgpa);
            ps.setInt(2, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("CGPA Updated Successfully!");

            } else {

                System.out.println("Student Not Found!");

            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }

    // ================= DELETE Operation =================
    public void deleteStudent(int studentId) {

        Connection con = DBConnection.getConnection();

        String query =
        "DELETE FROM student WHERE student_id = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Deleted Successfully!");

            } else {

                System.out.println("Student Not Found!");

            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }

}