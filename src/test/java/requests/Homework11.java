package requests;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Homework11 extends AutomationExerciseBaseUrl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();
    {
    "responseCode": 200,
    "products": [
        {
            "id": 1,
            "name": "Blue Top",
            "price": "Rs. 500",
            "brand": "Polo",
            "category": {
                "usertype": {
                    "usertype": "Women"
                },
                "category": "Tops"
            }
        },

*/

    @Test
    public void GetRequestTest(){

        //Set the Url
        spec.pathParams("first", "api", "second", "productsList");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.jsonPath().prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<String> womenUserTypelist = jsonPath.getList("products.findAll { it.category.usertype.usertype == 'Women'}");
        System.out.println("Women User Type list = " + womenUserTypelist);

        int NumWomenUserType = womenUserTypelist.size();
        System.out.println("Number of Women user type = " + NumWomenUserType);

        assertEquals(response.statusCode(), 200);
        assertEquals(NumWomenUserType, 12);
    }

}
