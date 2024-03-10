import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredTask {

    private  Response response ;
    public  String session = "";
    public static RequestSpecification requestSpecification;

        @Before
        public void BaseURL(){
            RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com/";
        }
    @Test
    public void viewCandidates ()
    {
        RestAssured.given().when().get("/web/index.php/recruitment/viewCandidates").then().statusCode(200);

    }

        @Test
    public void AddCandidates (){

         response = RestAssured.given().get("web/index.php/recruitment/viewCandidates");
         session = response.getCookie("orangehrm");

            String reqBody = "{\n" +
                    "\"firstName\": \"oo\",\n" +
                    "\"middleName\": \"bb\",\n" +
                    "\"lastName\": \"oo\",\n" +
                    "\"email\": \"aa@gmail.com\",\n" +
                    "\"contactNumber\": null,\n" +
                    "\"keywords\": null,\n" +
                    "\"comment\": null,\n" +
                    "\"dateOfApplication\": \"2024-03-10\",\n" +
                    "\"consentToKeepData\": false\n" +
                    "}";


        given().contentType(ContentType.JSON).header("Cookie","orangehrm="+session).body(reqBody).when().post("web/index.php/api/v2/recruitment/candidates").then().statusCode(200);

    }
    @Test
    public void ReturnAllCandidates ()
    {
        response = RestAssured.given().get("web/index.php/recruitment/viewCandidates");
        session = response.getCookie("orangehrm");
        RestAssured.given().header("Cookie","orangehrm="+session).when().get("web/index.php/api/v2/recruitment/candidates?limit=50&offset=0&model=list&sortField=candidate.dateOfApplication&sortOrder=DESC").then().statusCode(200);
        response = RestAssured.given().header("Cookie","orangehrm="+session).get("web/index.php/api/v2/recruitment/candidates?limit=50&offset=0&model=list&sortField=candidate.dateOfApplication&sortOrder=DESC");
        response.getBody();
    }
}
