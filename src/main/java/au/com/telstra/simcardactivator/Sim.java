package au.com.telstra.simcardactivator;

public class Sim {
    private String iccid;
    private String customerEmail;

    public Sim() {}

    public Sim(String iccid, String customerEmail) {
        super();
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    // Override toString method to create JSON string
    @Override
    public String toString() {
        return 
        "{iccid:" + iccid + 
        "customerEmail:" + customerEmail + "}";
    }

    // Getters and setters for properties
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String email) {
        this.customerEmail = email;
    }
    
}
