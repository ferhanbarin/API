package API.day05;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest05 {

/*
    http://dummy.restapiexample.com/api/v1/employees URL'ine
    Accept type'i "application/json" olan GET request'i yolladigimda
    Gelen response'un
    Status kodunun 200 ve content type'inin "application/json"
    Ve employees sayisinin 24
    Ve employee'lerden birinin "Ashton Cox"
    Ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
*/

    @Test
    public void test() {

        String URL = "http://dummy.restapiexample.com/api/v1/employees";

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(21, 23, 61));
    }
}
