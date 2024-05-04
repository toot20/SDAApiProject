package requests;

import base_urls.DummyBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;

public class Homework14 extends DummyBaseUrl {
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */
    @Test
    void groovyTest() {
        //Set the url
        spec.pathParams("first", "employees");

        Response response = given(spec).get("{first}");
        response.prettyPrint();

        response
                .then()
                .statusCode(200)//Satus code is 200
                .body(
                        "data", hasSize(24),
                        "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters")
                );

        // Extracting ages
        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println("Employee ages = " + ages);

        // Finding the greatest age
        int maxAge = -1;
        for (int age : ages) {
            if (age > maxAge) {
                maxAge = age;
            }
        }
        System.out.println("Greatest age = " + maxAge);

        // Asserting the greatest age
        assertEquals(66, maxAge);

        // Extracting ages and corresponding names
        List<String> names = response.jsonPath().getList("data.employee_name");
        System.out.println("Employee names = " + names);

        // Finding the index of the minimum age
        int minAgeIndex = -1;
        int minAge = Integer.MAX_VALUE;
        for (int i = 0; i < ages.size(); i++) {
            if (ages.get(i) < minAge) {
                minAge = ages.get(i);
                minAgeIndex = i;
            }
        }
        System.out.println("Index of the employee with the lowest age = " + minAgeIndex);

        // Getting the name of the employee with the lowest age
        String nameOfLowestAge = names.get(minAgeIndex);
        System.out.println("Name of the employee with the lowest age = " + nameOfLowestAge);

        // Asserting the name of the employee with the lowest age
        assertEquals("Tatyana Fitzpatrick", nameOfLowestAge);

        // Extracting salaries
        List<Integer> salaries = response.jsonPath().getList("data.employee_salary");
        System.out.println("employee_salary = " + salaries);

        // Calculating total salary
        int totalSalary = 0;
        for (Integer salary : salaries) {
            totalSalary += salary;
        }
        System.out.println("Total salary = " + totalSalary);

        // Asserting total salary
        assertEquals(6644770, totalSalary);
    }
}
