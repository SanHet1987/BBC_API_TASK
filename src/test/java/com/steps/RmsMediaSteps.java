package com.steps;

import com.restServices.ServiceLibrary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class RmsMediaSteps {

    private Response response;
    private String path;

    ServiceLibrary serviceLibrary = new ServiceLibrary();

    @Given("I create a new media endpoint")
    public void i_create_a_new_media_endpoint() {
        RestAssured.baseURI = "https://testapi.io/api";
        path = "/RMSTest/media";
    }

    @When("I send valid GET request")
    public void i_send_valid_get_request() {
        response = given().when().get(path).then().extract().response();
    }

    @Then("The status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        System.out.println("Status Code -----------> " + response.getStatusCode());
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("Verify response time {int}")
    public void verify_response_time(int responseTime) {
        serviceLibrary.responseTime(responseTime);
    }

    @Then("Id field should not be null or empty String")
    public void idFieldShouldNotBeNullOr() {
        serviceLibrary.setIdResponse();
    }

    @And("Segment Type field should be always Music")
    public void segmentTypeShouldBeAlwaysMusic() {
        serviceLibrary.setSegmentResponse();
    }

    @Then("Verify primary field under title list is not null or empty String")
    public void verifyPrimaryFieldIsNotNullOr() {
        serviceLibrary.setPrimaryTitleResponse();
    }

    @Then("Verify only second, now_playing field in offset as true")
    public void verifyOnlyOneFieldInAs() {
        serviceLibrary.setNowPlayingResponse();
    }

    @Then("Verify response header value for date")
    public void verifyValue() {
        serviceLibrary.verifyDateHeader();
    }

}
