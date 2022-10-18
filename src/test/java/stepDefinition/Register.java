package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Register {

    @Given("^valid email and password as payload for register api$")
    public void requestPayload(){

    }

    @When("^register api is called as POST http request$")
    public void sendRequest(){

    }


    @Then("^it should give 200 in response$")
    public void responseCode(){

    }

    @Then("^id and token should display in response$")
    public void responseValidation(){
        
    }
    
}
