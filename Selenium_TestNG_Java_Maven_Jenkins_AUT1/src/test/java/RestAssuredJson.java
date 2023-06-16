import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestAssuredJson {
    @Test

         public void getResponseResult() {
             baseURI ="https://reqres.in/api/unknown/23";
             given().
                     get("/api/unknown/23").
                     then().
                     assertThat().body(matchesJsonSchemaInClasspath("SearchComputer.json")).statusCode(404);
                     //body(computers)

         }
}






