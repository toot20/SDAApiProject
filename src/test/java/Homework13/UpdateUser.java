package Homework13;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetUserPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class UpdateUser extends PetStoreBaseUrl {
    @Test
    void putUserTest() {
        //Set the url
        spec.pathParams("first", "user", "second", "Toota");

        String strJson = """
                {
                "username": "Toota",
                "firstName": "Fatimah",
                "lastName": "Ahmed",
                "email": "re@gmail.com",
                "password": "757868",
                "phone": "09865577",
                "userStatus": 1
                }""";

        PetUserPojo expectedData = convertJsonToJava(strJson, PetUserPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        PetUserPojo actualData = convertJsonToJava(response.asString(), PetUserPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
    }

}