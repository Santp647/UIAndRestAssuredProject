package api.test;

import api.endpoints.UsersEndpoints;
import api.payload.pojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class userTestCases {

    public static Faker faker;
    public static pojo UserPayload;
    List<pojo> userList=new ArrayList<>();
    @BeforeTest

    public void setUpData() {
        faker = new Faker();

        for (int i=0;i<1;i++) {
            UserPayload = new pojo();

            UserPayload.setId(faker.idNumber().hashCode());
            UserPayload.setFirstName(faker.name().firstName());
            UserPayload.setUsername(faker.name().username());
            UserPayload.setLastName(faker.name().lastName());
            UserPayload.setPassword((faker.internet().password(5, 10)));
            UserPayload.setEmail(faker.internet().safeEmailAddress());
            UserPayload.setPhone(faker.phoneNumber().cellPhone());
            UserPayload.setUserStatus(1);

            userList.add(UserPayload);
        }
    }


    @Test(priority=1)
    public void  testCreateUser() {
        Response response = UsersEndpoints.createUser(userList);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority=2)
    public void testReadUser() {

        Response response = UsersEndpoints.readUser(this.UserPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

@Test(priority=3)
    public void testupadteUser(){
    UserPayload.setFirstName(faker.name().firstName());
    UserPayload.setLastName(faker.name().lastName());
    UserPayload.setEmail(faker.internet().safeEmailAddress());

        Response response= UsersEndpoints.updateUser(UserPayload, this.UserPayload.getUsername());
        response.then().log().all();

}

@Test(priority=4)
        public void deleteUser(){

            Response response =UsersEndpoints.deleteUser(this.UserPayload.getUsername());
            response.then().log().all();
    }
}

