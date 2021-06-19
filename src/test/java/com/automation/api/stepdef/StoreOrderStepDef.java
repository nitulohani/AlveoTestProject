package com.automation.api.stepdef;

import com.automation.api.model.Pet;
import com.automation.api.util.FileReader;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.sql.Date;

import static com.automation.api.util.RestUtils.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class StoreOrderStepDef {
    private final Gson gson = new Gson();
    private String endpoint;
    private Response response;


    @When("User places a request to order pet with PetId {int} id {int} quantity {int} date {string} status {string} complete {string}")
    public void userCreatesPostRequestToPlaceAnOrderForPetWithPetIdIdQuantityDateStatusComplete(Integer petId, Integer id, Integer quantity, String date, String status, Boolean complete) {
        Pet petPayload = new Pet(petId, id, quantity, date, status, complete);
        String petPayLoadJson = gson.toJson(petPayload);
        response = postEndpointIsHit(endpoint, petPayLoadJson);
    }

    @Given("User comes to the pet store")
    public void userComesToThePetStore() {
        endpoint = "https://petstore.swagger.io/v2/store/order";
    }

    @When("User places a request to order pet with Pet Id {int} id {int} quantity {int}")
    public void userPlacesARequestToOrderPetWithPetIdIdQuantity(int petId, int id, int quantity) {
        Pet petPayload = new Pet(petId, id, quantity);
        String petPayLoadJson = gson.toJson(petPayload);
        response = postEndpointIsHit(endpoint, petPayLoadJson);
    }

    @Then("^Assert Response is successful$")
    public void assertResponseIsSuccessful() {
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().prettyPrint());
    }

    @And("Response matches content same as {string}")
    public void responseMatchesContentSameAs(String fileName) {
        String expectedResponse = FileReader.readFile(fileName);
        assertEquals(expectedResponse, response.getBody().prettyPrint(), false);
    }

    @When("User places a request to order pet with Pet Id {int} id {int} quantity {int} shipdate {string} status {string} complete {string}")
    public void userPlacesARequestToOrderPetWithPetIdIdQuantityShipdateStatusComplete(int petId, int id, int quantity, String shipdate, String status, String complete) {
        Pet petPayload = new Pet(petId, id, quantity, shipdate, status, Boolean.parseBoolean(complete));
        String petPayLoadJson = gson.toJson(petPayload);
        response = postEndpointIsHit(endpoint, petPayLoadJson);
    }


    @When("User places a request find details with order {int}")
    public void userPlacesARequestFindDetailsWithOrder(int orderId) {
        response = getEndpointIsHit(endpoint + "/" + orderId);
    }

    @When("User places a request delete order with order orderid as {int}")
    public void userPlacesARequestDeleteOrderWithOrderOrderidAs(int orderId) {
        response = deleteEndpointIsHit(endpoint + "/" + orderId);
    }

    @When("User places a request to order an invalidOrder")
    public void userPlacesARequestToOrderAnInvalidOrder() {
        response = postEndpointIsHit(endpoint, "");
    }

    @Then("Assert Response is badRequest")
    public void assertResponseIsBadRequest() {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(400, response.getStatusCode());
    }

    @Then("Assert Response is notFound")
    public void assertResponseIsNotFound() {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(404, response.getStatusCode());
    }
}
