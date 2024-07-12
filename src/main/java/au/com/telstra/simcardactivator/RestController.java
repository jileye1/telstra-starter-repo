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
@RequestMapping(path = "/activate")
public class RestController {

    // Post request to activate sim
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public String activateSim(@RequestBody Sim sim) {

        String actuationUrl = "http://localhost:8444/actuate";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<String>(sim.toString(), headers);
        String successResponse = restTemplate.patchForObject(actuationUrl, request, Response.class).toString();
        return successResponse;

    }
    
}
