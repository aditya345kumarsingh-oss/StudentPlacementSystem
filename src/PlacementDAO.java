import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlacementDAO {


    // ADD Placement

    public void addPlacement(Placement placement) {

        // Get database connection
        Connection con = DBConnection.getConnection();


        String query =
        "INSERT INTO placement(student_id, company_id, placement_date, status) VALUES(?,?,?,?)";


        try {


            PreparedStatement ps = con.prepareStatement(query);


            ps.setInt(1, placement.getStudentId());

            ps.setInt(2, placement.getCompanyId());

            ps.setString(3, placement.getPlacementDate());

            ps.setString(4, placement.getStatus());


            ps.executeUpdate();


            System.out.println("Placement Added Successfully!");


        }
        catch(Exception e) {


            System.out.println("Error : " + e.getMessage());

        }

    }




    // VIEW All Placements with Student and Company Details

    public void getAllPlacements() {


        Connection con = DBConnection.getConnection();



        String query =

        "SELECT " +

        "placement.placement_id, " +

        "student.name, " +

        "student.email, " +

        "student.branch, " +

        "student.cgpa, " +

        "company.company_name, " +

        "company.location, " +

        "company.package_lpa, " +

        "placement.placement_date, " +

        "placement.status " +


        "FROM placement " +


        "JOIN student " +

        "ON placement.student_id = student.student_id " +


        "JOIN company " +

        "ON placement.company_id = company.company_id";




        try {



            PreparedStatement ps = con.prepareStatement(query);



            ResultSet rs = ps.executeQuery();



            System.out.println("\nPlacement Details");

            System.out.println("-----------------------------");



            while(rs.next()) {



                System.out.println("Placement ID : "
                + rs.getInt("placement_id"));



                System.out.println("Student Name : "
                + rs.getString("name"));



                System.out.println("Email : "
                + rs.getString("email"));



                System.out.println("Branch : "
                + rs.getString("branch"));



                System.out.println("CGPA : "
                + rs.getDouble("cgpa"));



                System.out.println("Company Name : "
                + rs.getString("company_name"));



                System.out.println("Location : "
                + rs.getString("location"));



                System.out.println("Package : "
                + rs.getDouble("package_lpa")
                + " LPA");



                System.out.println("Placement Date : "
                + rs.getString("placement_date"));



                System.out.println("Status : "
                + rs.getString("status"));



                System.out.println("-----------------------------");

            }



        }
        catch(Exception e) {


            System.out.println("Error : " + e.getMessage());

        }


    }

}