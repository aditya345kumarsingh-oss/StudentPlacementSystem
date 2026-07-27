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

        // Create Scanner and DAO object
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.println("\n===== Student Placement Management System =====");

        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student CGPA");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");

        System.out.print("\nEnter Your Choice : ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                sc.nextLine(); // Clear Buffer

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

                System.out.println("Thank You!");
                break;

            default:

                System.out.println("Invalid Choice!");

        }

        sc.close();
    }
}