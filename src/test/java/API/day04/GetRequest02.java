package API.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

/*
    https://restful-booker.herokuapp.com/booking URL'ine;
    Accept type'i "application/json" olan GET request'i yolladigimda gelen response'un status kodunun 200 content type'inin "application/json" oldugunu test edildi.
*/

    @Test
    public void test() {

        String URL = "https://restful-booker.herokuapp.com/booking";

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json");
    }
}
