package au.com.telstra.simcardactivator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Creating a REST Controller
@RestController
public class ActivationController {

    private final ActuationHandler actuationHandler;
    private final Repository simRepository;

    public ActivationController(ActuationHandler actuationHandler, Repository simRepository) {
        this.actuationHandler = actuationHandler;
        this.simRepository = simRepository;
    }

    // Post request to activate sim
    @PostMapping(path = "/activate", consumes = "application/json", produces = "application/json")
    public void activateSim(@RequestBody Sim sim) {

        ActuationResponse actuationResponse = actuationHandler.actuate(sim);
        sim.setActiveStatus(actuationResponse.getStatus());
        simRepository.save(sim);

        System.out.println(actuationResponse.getStatus());

    }

    @GetMapping(path = "/query", produces = "application/json")
    public Sim querySim(@RequestParam Long simCardId) {
        System.out.println("query");
        var simCard = simRepository.findById(simCardId).orElse(null);
        if (simCard == null) {
            return null;
        }
        //System.out.println(simRepository.findById(simCardId).orElse(null).toString());
        return simRepository.findById(simCardId).orElse(null);
    }
    
}
