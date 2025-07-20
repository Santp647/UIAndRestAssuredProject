package api.endpoints;

import api.payload.pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersEndpoints {

    public static Response createUser(pojo payload) {
        try {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
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
                    .pathParam("UserName", userName)
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
                    .pathParam("UserName", userName)
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
                    .pathParam("Username", userName)
                    .when()
                    .delete(route.delete_url);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
