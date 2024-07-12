package au.com.telstra.simcardactivator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActuationHandler {
    private final RestTemplate restTemplate;
    private final String actuationUrl;

    public ActuationHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.actuationUrl = "http://localhost:8444/actuate";
    }

    public ActuationResponse actuate(Sim sim) {
        return restTemplate.postForObject(actuationUrl, sim, ActuationResponse.class);
    }
    
}
