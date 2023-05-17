package api.test;

import api.endpoints.UserEndPoints;
import api.payload.UserDTO;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTCs {

    @Test(dataProvider = "data", dataProviderClass = DataProviders.class)
    public void TC_01_PostUser(String id, String userName, String fname, String lname, String email, String psw, String phone) {
        UserDTO userDTOPayload = new UserDTO();
        userDTOPayload.setId(Integer.parseInt(id));
        userDTOPayload.setUserName(userName);
        userDTOPayload.setFirstName(fname);
        userDTOPayload.setLastName(lname);
        userDTOPayload.setEmail(email);
        userDTOPayload.setPassword(psw);
        userDTOPayload.setPhone(phone);

        Response response = UserEndPoints.createUser(userDTOPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

//    @Test(dataProvider = "userNames", dataProviderClass = DataProviders.class)
//    public void TC_02_DeleteUser(String userName) {
//        Response response = UserEndPoints.deleteUser()
//    }
}
