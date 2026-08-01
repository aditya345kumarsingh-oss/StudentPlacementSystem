import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDAO {

    //          CREATE Operation
    public void addCompany(Company company) {

        // Get database connection
        Connection con = DBConnection.getConnection();

        // SQL INSERT query
        String query =
        "INSERT INTO company(company_name,location,package_lpa,minimum_cgpa) VALUES(?,?,?,?)";

        try {

            // Prepare SQL query
            PreparedStatement ps = con.prepareStatement(query);

            // Replace ? with company values
            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getLocation());
            ps.setDouble(3, company.getPackageLpa());
            ps.setDouble(4, company.getMinimumCgpa());

            // Execute INSERT query
            ps.executeUpdate();

            System.out.println("Company Added Successfully!");

        }
        catch(Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }



    //          READ Operation
    public void getAllCompanies() {

        // Get database connection
        Connection con = DBConnection.getConnection();

        // SQL SELECT query
        String query = "SELECT * FROM company";

        try {

            // Prepare SQL query
            PreparedStatement ps = con.prepareStatement(query);

            // Execute SELECT query
            ResultSet rs = ps.executeQuery();

            System.out.println("\nCompany List");
            System.out.println("----------------------");

            // Print every company one by one
            while(rs.next()) {

                System.out.println("ID : "
                + rs.getInt("company_id"));

                System.out.println("Company Name : "
                + rs.getString("company_name"));

                System.out.println("Location : "
                + rs.getString("location"));

                System.out.println("Package : "
                + rs.getDouble("package_lpa"));

                System.out.println("Minimum CGPA : "
                + rs.getDouble("minimum_cgpa"));

                System.out.println("----------------------");

            }

        }
        catch(Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }



    //          UPDATE Operation
    public void updateCompanyPackage(int companyId, double newPackage) {

        // Get database connection
        Connection con = DBConnection.getConnection();

        // SQL UPDATE query
        String query =
        "UPDATE company SET package_lpa = ? WHERE company_id = ?";

        try {

            // Prepare SQL query
            PreparedStatement ps = con.prepareStatement(query);

            // Replace first ? with new package
            ps.setDouble(1, newPackage);

            // Replace second ? with company ID
            ps.setInt(2, companyId);

            // Execute UPDATE query
            int rows = ps.executeUpdate();

            // Check whether update happened
            if(rows > 0) {

                System.out.println("Company Package Updated Successfully!");

            }
            else {

                System.out.println("Company Not Found!");

            }

        }
        catch(Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }



    //          DELETE Operation
    public void deleteCompany(int companyId) {

        // Get database connection
        Connection con = DBConnection.getConnection();

        // SQL DELETE query
        String query =
        "DELETE FROM company WHERE company_id = ?";

        try {

            // Prepare SQL query
            PreparedStatement ps = con.prepareStatement(query);

            // Replace ? with Company ID
            ps.setInt(1, companyId);

            // Execute DELETE query
            int rows = ps.executeUpdate();

            // Check whether deletion happened
            if(rows > 0) {

                System.out.println("Company Deleted Successfully!");

            }
            else {

                System.out.println("Company Not Found!");

            }

        }
        catch(Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }

}