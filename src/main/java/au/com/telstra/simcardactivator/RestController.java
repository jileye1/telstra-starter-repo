package au.com.telstra.simcardactivator;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// Creating a REST Controller
@RestController
public class RestController {

    private final ActuationHandler actuationHandler;

    public RestController(ActuationHandler actuationHandler) {
        this.actuationHandler = actuationHandler;
    }

    // Post request to activate sim
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public void activateSim(@RequestBody Sim sim) {

        ActuationResponse actuationResponse = actuationHandler.actuate(sim);
        System.out.println(actuationResponse.getStatus());

    }
    
}
