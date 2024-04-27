package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class AutomationExerciseBaseUrl {

    protected RequestSpecification spec;//This is null in this line, setUp() method should run before using this.

    @BeforeMethod //Runs before each @Test
    public void setUp(){

        spec = new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com")
                .setContentType(ContentType.JSON)
                .build();

    }


}
