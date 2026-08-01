import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlacementDAO {

    
    // ADD Placement
    
    public void addPlacement(Placement placement) {

        Connection con = DBConnection.getConnection();

        String query = "INSERT INTO placement(student_id, company_id, placement_date, status) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, placement.getStudentId());
            ps.setInt(2, placement.getCompanyId());
            ps.setString(3, placement.getPlacementDate());
            ps.setString(4, placement.getStatus());

            ps.executeUpdate();

            System.out.println("Placement Added Successfully!");

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }

    
    // VIEW All Placements
    
    public void getAllPlacements() {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT p.placement_id, s.name, s.email, s.branch, s.cgpa, " +
                "c.company_name, c.location, c.package_lpa, " +
                "p.placement_date, p.status " +
                "FROM placement p " +
                "JOIN student s ON p.student_id = s.student_id " +
                "JOIN company c ON p.company_id = c.company_id";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nPlacement Details");

            while (rs.next()) {

                System.out.println("-----------------------------");

                System.out.println("Placement ID : " + rs.getInt("placement_id"));
                System.out.println("Student Name : " + rs.getString("name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Branch : " + rs.getString("branch"));
                System.out.println("CGPA : " + rs.getDouble("cgpa"));

                System.out.println("Company Name : " + rs.getString("company_name"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Package : " + rs.getDouble("package_lpa") + " LPA");

                System.out.println("Placement Date : " + rs.getString("placement_date"));
                System.out.println("Status : " + rs.getString("status"));

                System.out.println("-----------------------------");
            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }

   
    // SEARCH Placement By Student ID
    
    public void searchPlacementByStudentId(int studentId) {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT s.name, s.email, s.branch, s.cgpa, " +
                "c.company_name, c.location, c.package_lpa, " +
                "p.placement_date, p.status " +
                "FROM placement p " +
                "JOIN student s ON p.student_id = s.student_id " +
                "JOIN company c ON p.company_id = c.company_id " +
                "WHERE s.student_id = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nPlacement Details");
                System.out.println("-----------------------------");

                System.out.println("Student Name : " + rs.getString("name"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Branch : " + rs.getString("branch"));
                System.out.println("CGPA : " + rs.getDouble("cgpa"));

                System.out.println("Company Name : " + rs.getString("company_name"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Package : " + rs.getDouble("package_lpa") + " LPA");

                System.out.println("Placement Date : " + rs.getString("placement_date"));
                System.out.println("Status : " + rs.getString("status"));

                System.out.println("-----------------------------");

            } else {

                System.out.println("No Placement Record Found!");

            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }


   
// SEARCH Placement By Student Name

public void searchPlacementByStudentName(String studentName) {

    Connection con = DBConnection.getConnection();

    String query =
            "SELECT s.name, s.email, s.branch, s.cgpa, " +
            "c.company_name, c.location, c.package_lpa, " +
            "p.placement_date, p.status " +
            "FROM placement p " +
            "JOIN student s ON p.student_id = s.student_id " +
            "JOIN company c ON p.company_id = c.company_id " +
            "WHERE s.name = ?";

    try {

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, studentName);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("\nPlacement Details");
            System.out.println("-----------------------------");

            System.out.println("Student Name : " + rs.getString("name"));
            System.out.println("Email : " + rs.getString("email"));
            System.out.println("Branch : " + rs.getString("branch"));
            System.out.println("CGPA : " + rs.getDouble("cgpa"));

            System.out.println("Company Name : " + rs.getString("company_name"));
            System.out.println("Location : " + rs.getString("location"));
            System.out.println("Package : " + rs.getDouble("package_lpa") + " LPA");

            System.out.println("Placement Date : " + rs.getString("placement_date"));
            System.out.println("Status : " + rs.getString("status"));

            System.out.println("-----------------------------");

        } else {

            System.out.println("No Placement Record Found!");

        }

    } catch (Exception e) {

        System.out.println("Error : " + e.getMessage());

    }
}


// UPDATE Placement Status

public void updatePlacementStatus(int placementId, String newStatus) {

    Connection con = DBConnection.getConnection();

    String query = "UPDATE placement SET status = ? WHERE placement_id = ?";

    try {

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, newStatus);
        ps.setInt(2, placementId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Placement Status Updated Successfully!");
        } else {
            System.out.println("Placement ID Not Found!");
        }

    } catch (Exception e) {

        System.out.println("Error : " + e.getMessage());

    }
}

}