public class Placement {

    // Variables
    private int placementId;
    private int studentId;
    private int companyId;
    private String placementDate;
    private String status;

    // Constructor
    public Placement(int placementId,
                     int studentId,
                     int companyId,
                     String placementDate,
                     String status) {

        this.placementId = placementId;
        this.studentId = studentId;
        this.companyId = companyId;
        this.placementDate = placementDate;
        this.status = status;
    }

    // Getter Methods

    public int getPlacementId() {
        return placementId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getPlacementDate() {
        return placementDate;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setPlacementDate(String placementDate) {
        this.placementDate = placementDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}