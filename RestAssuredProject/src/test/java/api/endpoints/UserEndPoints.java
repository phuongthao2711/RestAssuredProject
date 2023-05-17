package api.endpoints;

import api.payload.UserDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    /**
     *  Create for perform CRUD requests to the user API
     **/

    public static Response createUser(UserDTO payload) {
        Response response = given().contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                .when()
                    .post(Routes.postURL);
        return response;
    }

    public static Response readUser(int id) {
        Response response = given().pathParam("id", id)
                .when().get(Routes.getURL);
        return response;
    }

    public static Response updateUser(int id, UserDTO payload) {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", id)
                .body(payload)
                .when()
                .put(Routes.updateURL);
        return response;
    }

    public static Response deleteUser(int id) {
        Response response = given().pathParam("id", id)
                .when()
                .delete(Routes.deleteURl);
        return response;
    }
}
