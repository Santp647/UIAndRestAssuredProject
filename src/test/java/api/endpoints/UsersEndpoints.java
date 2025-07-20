package api.endpoints;

import api.payload.pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersEndpoints {

    public static Response createUser(List<pojo> userList) {
        try {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(userList)
                    .when()
                    .post(route.post_url);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Response readUser(String userName) {
        try {
            Response response = given()
                    .pathParam("username", userName)
                    .when()
                    .get(route.get_url);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Response updateUser(pojo payload, String userName) {
        try {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("username", userName)
                    .body(payload)
                    .when()
                    .put(route.put_url);
            return response;

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static Response deleteUser(String userName) {

        try {
            Response response = given()
                    .pathParam("username", userName)
                    .when()
                    .delete(route.delete_url);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
