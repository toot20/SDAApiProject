package Homework13;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetUserPojo;

//import static Homework13.CreateUser.username;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class GetUser extends PetStoreBaseUrl {
    @Test
    void getUserTest() {
        //Set the url
        spec.pathParams("first", "user", "second", "Toota");

        String strJson = """
                {
                "username": "Toota",
                "firstName": "Atikah",
                "lastName": "Almutlq",
                "email": "Test@gmail.com",
                "password": "992216",
                "phone": "055559788",
                "userStatus": 0
                }""";

        PetUserPojo expectedData = convertJsonToJava(strJson, PetUserPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        PetUserPojo actualData = convertJsonToJava(response.asString(), PetUserPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getfirstName(), expectedData.getfirstName());
        assertEquals(actualData.getlastName(), expectedData.getlastName());
        assertEquals(actualData.getEmail(), expectedData.getEmail());
        assertEquals(actualData.getPassword(), expectedData.getPassword());
        assertEquals(actualData.getPhone(), expectedData.getPhone());
        assertEquals(actualData.getUserStatus(), expectedData.getUserStatus());
    }
}
