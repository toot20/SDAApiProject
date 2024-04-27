package requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.PetStore_UserTestData;

import java.util.Map;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.given;

public class Homework9 extends PetStoreBaseUrl {
    /*
    https://petstore.swagger.io/v2/user
    {
  "id": 0,
  "username": "string",
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "password": "string",
  "phone": "string",
  "userStatus": 0
}
     */
    @Test(priority = 1)
    public void postRequestTest(){

        spec.pathParams("first","user");

        Map<String, Object > expectedData = PetStore_UserTestData.expectedDataMethod("Toota", "Atikah", "Almutlq", "Test@gmail.com", "992216", "055559788", 0);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(Map.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 2)
    public void GetRequestTest(){

        Map<String, Object > expectedData = PetStore_UserTestData.expectedDataMethod("Toota", "Atikah", "Almutlq", "Test@gmail.com", "992216", "055559788", 0);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).get("user/Toota");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(Map.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.get("username"), expectedData.get("username"));
        assertEquals(actualData.get("firstName"), expectedData.get("firstName"));
        assertEquals(actualData.get("lastName"), expectedData.get("lastName"));
        assertEquals(actualData.get("email"), expectedData.get("email"));
        assertEquals(actualData.get("password"), expectedData.get("password"));
        assertEquals(actualData.get("phone"), expectedData.get("phone"));
        assertEquals(actualData.get("userStatus"), expectedData.get("userStatus"));
    }
}
