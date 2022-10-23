package stepDefinition.Maps;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import manager.Maps.AddPlaceManager;
import utilities.CommonApi;

public class AddPlace {
    AddPlaceManager addPlace = new AddPlaceManager();
    CommonApi commonApi = new CommonApi();
    String body = null;
    Response result = null;
    Integer successCode = 200;
    String dataFilePath = "/src/main/resources/testProperties/Map/AddPlace.properties";
    String urlPath = "/src/main/java/constants/UrlConfig.properties";
    
    @Given("^valid request payload is passed for add place api$")
    public void requestPayload(){
        Double lat = -38.383494;
        Double lng = 33.427362;
        Integer accuracy = 50;
        List <String> types = new ArrayList<String>();
        types.add("shoe park");
        types.add("Shop");
        String name = commonApi.getPropFileValue("name", dataFilePath);
        String phoneNumber = commonApi.getPropFileValue("phoneNumber", dataFilePath);
        String address = commonApi.getPropFileValue("address", dataFilePath);
        String website = commonApi.getPropFileValue("website", dataFilePath);
        String language = commonApi.getPropFileValue("language", dataFilePath);
        body = addPlace.requestBody(lat, lng, accuracy, name, phoneNumber, address, types, website, language);
    }

    @When("^add place api request is called$")
    public void sendRequest(){
        String url = commonApi.getPropFileValue("Maps", urlPath);
        result = addPlace.addPlaceRequest(url, body);
    }

    @Then("it should give {int} status code in response")
    public void responseCode(Integer responseCode){
        Integer statusCode = result.getStatusCode();
        Assert.assertEquals(responseCode, statusCode);
    }

    @Then("{string} in response should be {string}")
    public void responseValidation(String key, String value){
        String output = commonApi.getResponseValue(result, key);
        Assert.assertEquals(value, output);
    }
}
