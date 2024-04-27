package requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Homework3 {
         /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void homework3Test(){

//        https://reqres.in/api/users/3
        String url = "https://reqres.in/api/users/3";

//        User sends a GET Request to the url
        Response response = given().get(url);
        response.prettyPrint();

//        HTTP Status Code should be 200
        response.then().statusCode(200);
//        Content Type should be JSON
        response.then().contentType("application/json");
//        Status Line should be HTTP/1.1 200 OK
        response.then().statusLine("HTTP/1.1 200 OK");
    }
}
