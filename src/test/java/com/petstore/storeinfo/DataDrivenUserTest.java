package com.petstore.storeinfo;


import com.petstore.petstoreinfo.UserSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/user.csv")
@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenUserTest {
    static int id;
    static String username ;
    static String firstName ;
    static String lastName ;

    static String email ;
    static String password ;
    static String phone ;
    static int userStatus ;
    static ValidatableResponse response;
    @Steps
    UserSteps userSteps;

    @Title("Data driven test for create multiple user")
    @Test
    public void createMultipleUsers() {
        response = userSteps.createUser(id, username, firstName, lastName, email, password, phone, userStatus).statusCode(200);
    }
}
