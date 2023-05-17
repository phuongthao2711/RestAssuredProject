package api.test;

import api.endpoints.UserEndPoints;
import api.payload.UserDTO;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class UserTCs {

    Faker faker;
    UserDTO userDTOPayload;
    int id;

    @BeforeTest
    public void setUpData() {
        faker = new Faker();
        userDTOPayload = new UserDTO();

        userDTOPayload.setId(faker.idNumber().hashCode());
        userDTOPayload.setUserName(faker.name().username());
        userDTOPayload.setFirstName(faker.name().firstName());
        userDTOPayload.setLastName(faker.name().lastName());
        userDTOPayload.setEmail(faker.internet().safeEmailAddress());
        userDTOPayload.setPassword(faker.internet().password(5, 10));
        userDTOPayload.setPhone(faker.phoneNumber().cellPhone());

    }

    @Test(priority = 1)
    public void testPostUser() {
        Response response = UserEndPoints.createUser(userDTOPayload);
        response.then().log().all();
        id = userDTOPayload.getId();
        System.out.println(">>>>>>>>>>>>>>>>>>" + id);

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Ignore
    @Test(priority = 2)
    public void testGetUserByName() {
        System.out.println(">>>>>>>>>>>>>>>>>>" + id);
        Response response = UserEndPoints.readUser(id);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

//        given()
//                .pathParam("username", userName)
//                when()
//                .get("https://petstore.swagger.io/v2/user/" + userName)
//                .then()
//                .statusCode(200)
//                .log().all();
    }

    @Ignore
    @Test(priority = 3)
    public void testUpdateUser() {
        //Update data
        userDTOPayload.setFirstName(faker.name().firstName());
        userDTOPayload.setLastName(faker.name().lastName());
        userDTOPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndPoints.updateUser(id, userDTOPayload);
        response.then().log().body().statusCode(200);

        //Checking data after update
        Response responseAfterUpdate = UserEndPoints.readUser(id);
        responseAfterUpdate.then().log().all().statusCode(200);

    }

    @Ignore
    @Test(priority = 4)
    public void deleteUser() {
        Response response = UserEndPoints.deleteUser(id);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
