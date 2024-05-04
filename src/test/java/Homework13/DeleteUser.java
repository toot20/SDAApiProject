package Homework13;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class DeleteUser extends PetStoreBaseUrl {
    @Test
    void deleteUserTest(){
        //Set the url
        spec.pathParams("first", "user", "second", "Toota");

        //Set the expected data
        //String expectedData = "Created";

        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(response.statusCode(), 200);
       // assertEquals(response.asString(), expectedData);

    }
}
