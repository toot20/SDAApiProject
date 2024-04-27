package requests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.ReqresTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework8 extends ReqresBaseUrl {
      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
    @Test
    public void homework8Test(){

        spec.pathParams("first", "users");

        Map<String, Object> expectedData = ReqresTestData.expectedDataMap("morpheus","leader");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        response
                .then()
                .statusCode(201)
                .body("name", equalTo(expectedData.get("morpheus")),
                        "job", equalTo(expectedData.get("leader")));
    }
}
