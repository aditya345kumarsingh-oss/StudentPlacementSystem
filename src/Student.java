public class Student {

    // Instance Variables (Fields)

    private int studentId;
    private String name;
    private String email;
    private String phone;
    private String course;
    private String branch;
    private double cgpa;
    private int passingYear;

    // Default Constructor

    public Student() {

    }

    // Parameterized Constructor

    public Student(int studentId, String name, String email, String phone,
                   String course, String branch, double cgpa, int passingYear) {

        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.branch = branch;
        this.cgpa = cgpa;
        this.passingYear = passingYear;
    }

    public int getStudentId() {
    return studentId;
}

public String getName() {
    return name;
}

public String getEmail() {
    return email;
}

public String getPhone() {
    return phone;
}

public String getCourse() {
    return course;
}

public String getBranch() {
    return branch;
}

public double getCgpa() {
    return cgpa;
}

public int getPassingYear() {
    return passingYear;
}

}