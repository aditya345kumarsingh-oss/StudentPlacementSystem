

public class Company {

    // Instance variables (same as company table columns)

    private int companyId;
    private String companyName;
    private String location;
    private double packageLpa;
    private double minimumCgpa;

    // Default Constructor
   
    public Company() {

    }

    // Parameterized Constructor
    // Used when we already have all company details
    public Company(int companyId, String companyName,
                   String location, double packageLpa,
                   double minimumCgpa) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.location = location;
        this.packageLpa = packageLpa;
        this.minimumCgpa = minimumCgpa;

    }

    // Getter for Company ID
    public int getCompanyId() {
        return companyId;
    }

    // Setter for Company ID
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    // Getter for Company Name
    public String getCompanyName() {
        return companyName;
    }

    // Setter for Company Name
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getter for Location
    public String getLocation() {
        return location;
    }

    // Setter for Location
    public void setLocation(String location) {
        this.location = location;
    }

    // Getter for Package
    public double getPackageLpa() {
        return packageLpa;
    }

    // Setter for Package
    public void setPackageLpa(double packageLpa) {
        this.packageLpa = packageLpa;
    }

    // Getter for Minimum CGPA
    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    // Setter for Minimum CGPA
    public void setMinimumCgpa(double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

}