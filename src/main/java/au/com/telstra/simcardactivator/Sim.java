package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sim {
    private String iccid;
    private String customerEmail;
    private boolean active;

    public Sim() {}

    public Sim(String iccid, String customerEmail, boolean active) {
        super();
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    // Override toString method to create JSON string
    @Override
    public String toString() {
        return 
        "{iccid:" + iccid + 
        ", customerEmail:" + customerEmail +
        ", active:" + active   
        + "}";
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

    public boolean getActiveStatus() {
        return active;
    }

    public void setActiveStatus(boolean active) {
        this.active = active;
    }
    
}
