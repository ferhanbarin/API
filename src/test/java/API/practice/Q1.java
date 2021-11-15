package API.practice;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Q1 {

/*
    https://restful-booker.herokuapp.com/booking/10 URL'ine bir GET request gonderdigimizde donen Response'un,
    Status code'unun 200,
    Ve content type'inin application/json; charset=utf-8,
    Ve Server isimli Header'in degerinin Cowboy,
    Ve status Line'in HTTP/1.1 200 OK
    Ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
*/

    @Test
    public void test() {

        String URL = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();


        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");

        Assert.assertTrue(response.time() < 5000);
    }
}
