package requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework7 extends ReqresBaseUrl {
      /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */
    @Test
    public void homework7Test(){
        //Set the Url
        spec.pathParams("first", "unknown");

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        //1)Status code is 200
        response.then().statusCode(200);

        //2)Print all pantone_values
        List<String> pantoneValuelist = jsonPath.getList("data.pantone_value");
        System.out.println("pantone_values = " + pantoneValuelist);

        //3)Print all ids greater than 3 on the console
        //Assert that there are 3 ids greater than 3
        List<Integer> idlist = jsonPath.getList("data.id");
        System.out.println("idlist = " + idlist);
        int idsGreaterThan3 = 0;
        for (int w : idlist) {

            if (w > 3) {
                System.out.println(w);
                idsGreaterThan3++;
            }
        }
        assertEquals(idsGreaterThan3, 3);

        //4)Print all names whose ids are less than 3 on the console
        //Assert that the number of names whose ids are less than 3 is 2
        List<String> nameslist = jsonPath.getList("data.findAll{it.id < 3 }.name");
        System.out.println("names = " + nameslist);
        assertEquals(nameslist.size(), 2);
    }
}
