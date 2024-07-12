package stepDefinitions;

import au.com.telstra.simcardactivator.Sim;
import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private Sim sim;

    @Given("a functional sim card")
    public void aFunctionalSimCard() {
        sim = new Sim("1255789453849037777", "functional@sim.com", false);
    }

    @Given("a broken sim card")
    public void aBrokenSimCard() {
        sim = new Sim("8944500102198304826", "broken@sim.com", false);
    }

    @When("a request to activate the sim card is submitted")
    public void aRequestToActivateTheSimIsSubmitted() {
        this.restTemplate.postForObject("http://localhost:8080/activate", sim, String.class);
    }

    @Then("the sim card is activated and its state is recorded to the database")
    public void theSimCardIsActivatedAndItsStateIsRecordedToTheDatabase() {
        var simCard = this.restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", Sim.class, 1);
        assertTrue(simCard.getActiveStatus());
    }

    @Then("the sim card fails to activate and its state is recorded to the database")
    public void theSimCardFailsToActivateAndItsStateIsRecordedToTheDatabase() {
        var simCard = this.restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", Sim.class, 2);
        assertFalse(simCard.getActiveStatus());
    }

}