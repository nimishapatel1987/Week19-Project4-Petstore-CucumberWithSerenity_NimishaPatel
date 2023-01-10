package com.petstore.cucumber.steps;

import com.petstore.petstoreinfo.UserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class StepsOfUser {
    static int id = 8;
    static String username = "Parvati";
    static String firstName = "Krish";
    static String lastName = "Patel";

    static String email = "krish@gmail.com";
    static String password = "krish123";
    static String phone = "07896584758";
    static int userStatus = 0;
    static ValidatableResponse response;
    @Steps
    UserSteps userSteps;

    @When("^User send a post request to create user$")
    public void userSendAPostRequestToCreateUser() {
        response=userSteps.createUser(id,username,firstName,lastName,email,password,phone,userStatus);
    }

    @Then("^User must be created and validate the response$")
    public void userMustBeCreatedAndValidateTheResponse() {
        response.statusCode(200);
      // response.body("message",equalTo("ok"));
    }

    @When("^User send a get request with username$")
    public void userSendAGetRequestWithUsername() {
        HashMap<String,Object> userMap    =  userSteps.getUserByUserName1(username);
      // HashMap<String,Object> userMap= response.extract().body();
        Assert.assertThat(userMap,hasValue(username));
    }

    @Then("^User should get data of created user and validate response code$")
    public void userShouldGetDataOfCreatedUserAndValidateResponseCode() {
        response.statusCode(200);
    }

    @When("^User send a Put request to upgate user$")
    public void userSendAPutRequestToUpgateUser() {
        username=username+"_add";
        response=userSteps.updateUserByUserName(id,username,firstName,lastName,email,password,phone,userStatus);

    }

    @Then("^User suould see updated user and validate response$")
    public void userSuouldSeeUpdatedUserAndValidateResponse() {
        response.statusCode(200);
    }

    @When("^User send a delete request$")
    public void userSendADeleteRequest() {
        response=userSteps.deleteUserWithUserName(username).statusCode(200);
    }

    @Then("^User should see user is deleted and check status code$")
    public void userShouldSeeUserIsDeletedAndCheckStatusCode() {
        response=userSteps.getUserByUserName(username).statusCode(404);
    }
}
