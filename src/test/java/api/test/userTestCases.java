package api.test;

import api.endpoints.UsersEndpoints;
import api.payload.pojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class userTestCases {

    public static Faker faker;
    public static pojo payload;

    @BeforeTest

    public void setupDATA() {
        faker = new Faker();
        payload = new pojo();

        payload.setId(faker.idNumber().hashCode());
        payload.setFirstName(faker.name().firstName());
        payload.setUsername(faker.name().username());
        payload.setLastName(faker.name().lastName());
        payload.setPassword((faker.internet().password(5, 10)));
        payload.setEmail(faker.internet().safeEmailAddress());
        payload.setPhone(faker.phoneNumber().cellPhone());

    }


    @Test(priority=1)
    public Void testCreateUser() {
        Response response = UsersEndpoints.createUser(payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 201);
        return null;
    }

    @Test(priority=2)
    public void testReadUser(){

        Response response=UsersEndpoints.readUser(id);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

@Test
    public void testupadteUser(){


        Response response= UsersEndpoints.updateUser(payload, payload.getUsername());
        response.then();
}



}
