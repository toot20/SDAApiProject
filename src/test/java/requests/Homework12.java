package requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework12 extends PetStoreBaseUrl {
   /* Write an automation test that will
        create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
        https://petstore.swagger.io/v2/pet
        {
  "id": 55221,
  "category": {
    "id": 0,
    "name": "Fish"
  },
  "name": "Fishie",
  "photoUrls": ["best foto", "beauty", "pool"],
  "tags": [
    {
      "id": 0,
      "name": "Fast"
    }
  ],
  "status": "sold"
}
        */

    @Test(priority = 1)
    public void CreateRequestTest(){
        //Set the url
        spec.pathParams("first", "pet");

        //Set the expected data
        PetCategoryPojo PetCategoryPojo = new PetCategoryPojo(0, "Fish") ;
        PetTagsPojo PetTagsPojo = new PetTagsPojo(0, "Fast") ;
        PetOuterpojo expectedData = new PetOuterpojo(55221, PetCategoryPojo, "Fishie", Arrays.asList("best foto", "beauty", "pool"), Collections.singletonList(PetTagsPojo),"sold");

        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        PetOuterpojo actualData = response.as(PetOuterpojo.class);//De-Serialization can not be done without default constructor in corresponding Pojo class
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getid(), expectedData.getid());
        assertEquals(actualData.getcategory().getid(), PetCategoryPojo.getid());
        assertEquals(actualData.getcategory().getname(), PetCategoryPojo.getname());
        assertEquals(actualData.getname(), expectedData.getname());
        assertEquals(actualData.getphotoUrls(), expectedData.getphotoUrls());
        assertEquals(actualData.gettags().get(0).getid(), PetTagsPojo.getid());
        assertEquals(actualData.gettags().get(0).getname(), PetTagsPojo.getname());
        assertEquals(actualData.getstatus(), expectedData.getstatus());

    }
    @Test(priority = 2)
    public void GetRequestTest(){

        PetCategoryPojo PetCategoryPojo = new PetCategoryPojo(0, "Fish") ;
        PetTagsPojo PetTagsPojo = new PetTagsPojo(0, "Fast") ;
        PetOuterpojo expectedData = new PetOuterpojo(55221, PetCategoryPojo, "Fishie", Arrays.asList("best foto", "beauty", "pool"), Collections.singletonList(PetTagsPojo),"sold");

        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).get("pet/55221");//Parameters can be declared directly here
        response.prettyPrint();

        PetOuterpojo actualData = response.as(PetOuterpojo.class);//De-Serialization can not be done without default constructor in corresponding Pojo class
        System.out.println("actualData = " + actualData);

    }
    @Test(priority = 3)
    public void UpdateRequestTest(){
        PetCategoryPojo PetCategoryPojo = new PetCategoryPojo(1, "Chicken") ;
        PetTagsPojo PetTagsPojo = new PetTagsPojo(5, "Red") ;
        PetOuterpojo expectedData = new PetOuterpojo(55221, PetCategoryPojo, "doggie", Arrays.asList("best", "run", "low"), Collections.singletonList(PetTagsPojo),"solt");

        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).put("pet");//Parameters can be declared directly here
        response.prettyPrint();

        PetOuterpojo actualData = response.as(PetOuterpojo.class);//De-Serialization can not be done without default constructor in corresponding Pojo class
        System.out.println("actualData = " + actualData);
    }
    @Test(priority = 4)
    public void DeleteRequestTest() {

        //Set the expected data
        Map<Object, Object> expectedData = new HashMap<>();

        //Send the request and get the response
        Response response = given(spec).delete("pet/55221");
        response.prettyPrint();

        //Do assertion
        Map<Object, Object> actualData = response.as(Map.class);
        System.out.println("actualData = " + actualData);

        //Assertion logic is up to you
        assertEquals(response.statusCode(), 200);

    }

}

