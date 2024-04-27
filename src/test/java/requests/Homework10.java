package requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework10 {
/*
    Using the https://petstore.swagger.io/v2/pet/findByStatus?status=available document, write an automation test that finds the number of "pets" with the status "available" and asserts that there are more than 100.
*/
    @Test
    public void GetRequestTest(){
        String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
        Response response = given().get(url);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<String> availablePetStatuslist = jsonPath.getList("status");
        System.out.println("Available Pet Status list = " + availablePetStatuslist);

        int availablePetsCount = availablePetStatuslist.size();
        assert availablePetsCount > 100 : "Expected more than 100 available pets, but found " + availablePetsCount;
        System.out.println("More than 100 pets 'available' = " + availablePetsCount);
    }
}
