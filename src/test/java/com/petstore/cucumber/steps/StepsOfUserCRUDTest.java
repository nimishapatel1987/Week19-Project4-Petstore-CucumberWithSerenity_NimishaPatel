package com.petstore.cucumber.steps;

import com.petstore.petstoreinfo.UserSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class StepsOfUserCRUDTest {
    static ValidatableResponse response;
    @Steps
    UserSteps userSteps;

     static String userName1="parvati";
    @When("^I create a new student by providing the information id \"([^\"]*)\" username\"([^\"]*)\"  firstName\"([^\"]*)\" lastName\"([^\"]*)\" email\"([^\"]*)\" password\"([^\"]*)\" phone\"([^\"]*)\" userStatus\"([^\"]*)\"$")
    public void iCreateANewStudentByProvidingTheInformationIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatus(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus)  {
       response=userSteps.createUser(id,userName1,firstName,lastName,email,password,phone,userStatus).statusCode(200);

    }

    @Then("^I verify that user is created with given firstname$")
    public void iVerifyThatUserIsCreatedWithGivenFirstname() {
        HashMap<String,Object> userMap    =  userSteps.getUserByUserName1(userName1);
        // HashMap<String,Object> userMap= response.extract().body();
        Assert.assertThat(userMap,hasValue(userName1));
    }


    @And("^I Update user with id \"([^\"]*)\" username\"([^\"]*)\"  firstName\"([^\"]*)\" lastName\"([^\"]*)\" email\"([^\"]*)\" password\"([^\"]*)\" phone\"([^\"]*)\" userStatus\"([^\"]*)\"$")
    public void iUpdateUserWithIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatus(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus)  {
      userName1=userName1+"_add";
      response=userSteps.updateUserByUserName(id,userName1,firstName,lastName,email,password,phone,userStatus);
    }

    @And("^I check user is updated successfully$")
    public void iCheckUserIsUpdatedSuccessfully() {
        response.statusCode(200);
    }

    @And("^I delete userwith username$")
    public void iDeleteUserwithUsername() {
        response=userSteps.deleteUserWithUserName(userName1).statusCode(200);
    }

    @Then("^I check user is deleted successfully$")
    public void iCheckUserIsDeletedSuccessfully() {
        response=userSteps.getUserByUserName(userName1).statusCode(404);
    }
}
