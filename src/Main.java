import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Connect to Database
        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Database Connection Failed!");
            return;
        }

        // Create Scanner
        Scanner sc = new Scanner(System.in);

        // Create DAO Objects
        StudentDAO dao = new StudentDAO();
        CompanyDAO companyDao = new CompanyDAO();

        System.out.println("====================================");
        System.out.println(" Student Placement Management System");
        System.out.println("====================================");

        System.out.println("\n----- Student Module -----");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student CGPA");
        System.out.println("4. Delete Student");

        System.out.println("\n----- Company Module -----");
        System.out.println("5. Add Company");
        System.out.println("6. View All Companies");

        System.out.println("\n----- Company Module -----");
        System.out.println("5. Add Company");
        System.out.println("6. View All Companies");
        System.out.println("7. Update Company Package");

       

        System.out.println("\n0. Exit");

        System.out.print("\nEnter Your Choice : ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Email : ");
                String email = sc.nextLine();

                System.out.print("Enter Phone : ");
                String phone = sc.nextLine();

                System.out.print("Enter Course : ");
                String course = sc.nextLine();

                System.out.print("Enter Branch : ");
                String branch = sc.nextLine();

                System.out.print("Enter CGPA : ");
                double cgpa = sc.nextDouble();

                System.out.print("Enter Passing Year : ");
                int year = sc.nextInt();

                Student s = new Student(
                        0,
                        name,
                        email,
                        phone,
                        course,
                        branch,
                        cgpa,
                        year
                );

                dao.addStudent(s);
                dao.getAllStudents();

                break;

            case 2:

                dao.getAllStudents();

                break;

            case 3:

                System.out.print("Enter Student ID : ");
                int id = sc.nextInt();

                System.out.print("Enter New CGPA : ");
                double newCgpa = sc.nextDouble();

                dao.updateStudentCGPA(id, newCgpa);
                dao.getAllStudents();

                break;

            case 4:

                System.out.print("Enter Student ID : ");
                int deleteId = sc.nextInt();

                dao.deleteStudent(deleteId);
                dao.getAllStudents();

                break;

            case 5:

                sc.nextLine();

                System.out.print("Enter Company Name : ");
                String companyName = sc.nextLine();

                System.out.print("Enter Company Location : ");
                String location = sc.nextLine();

                System.out.print("Enter Package (LPA) : ");
                double packageLpa = sc.nextDouble();

                System.out.print("Enter Minimum CGPA : ");
                double minimumCgpa = sc.nextDouble();

                Company company = new Company(
                        0,
                        companyName,
                        location,
                        packageLpa,
                        minimumCgpa
                );

                companyDao.addCompany(company);
                companyDao.getAllCompanies();

                break;

            case 6:

                companyDao.getAllCompanies();

                break;


            case 7:

                System.out.print("Enter Company ID : ");
                int companyId = sc.nextInt();

                System.out.print("Enter New Package (LPA) : ");
                double newPackage = sc.nextDouble();

                companyDao.updateCompanyPackage(companyId, newPackage);

                companyDao.getAllCompanies();

                break;

            case 0:

                System.out.println("Thank You!");
                break;

            default:

                System.out.println("Invalid Choice!");

        }

        sc.close();
    }
}
