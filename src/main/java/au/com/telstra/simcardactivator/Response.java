package au.com.telstra.simcardactivator;

public class Response {

    private Boolean success;

    public Response() {}

    public Response(Boolean success) {
        super();
        this.success = success;
    }

    public Boolean getStatus() {
        return success;
    }

    public void setStatus(Boolean success) {
        this.success = success;
    }
    
}
