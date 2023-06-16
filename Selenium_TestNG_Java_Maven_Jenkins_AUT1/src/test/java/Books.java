import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

    public class Books{
        @Test
        public void GetBooksDetails() {

            RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1/Books";

            // Get the RequestSpecification of the request to be sent to the server.
            RequestSpecification httpRequest = RestAssured.given();

            // specify the method type (GET) and the parameters if any.
            Response response = httpRequest.request(Method.GET, "");

            System.out.println("Status received => " + response.getStatusLine());
            System.out.println("Response=>" + response.prettyPrint());

        }
    }


