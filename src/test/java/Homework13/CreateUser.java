package Homework13;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetUserPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class CreateUser extends PetStoreBaseUrl {
    /*    {

                "username": "string",
                "firstName": "string",
                "lastName": "string",
                "email": "string",
                "password": "string",
                "phone": "string",
                "userStatus": 0
        }*/
    //public static String username;
    @Test
    public void postRequestTest() {

        spec.pathParams("first", "user");

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

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        PetUserPojo actualData = convertJsonToJava(response.asString(), PetUserPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);

        //username = actualData.getUsername();


    }
}
