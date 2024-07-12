package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuationResponse {

    private boolean success;

    public ActuationResponse() {}

    public ActuationResponse(boolean success) {
        super();
        this.success = success;
    }

    public boolean getStatus() {
        return success;
    }

    public void setStatus(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Actuation result: success = " + success;
    }
    
}
