package API.day05;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 {

/*
    https://jsonplaceholder.typicode.com/todos/123 URL'ine
    Accept type'i "application/json" olan GET request'i yolladigimda
    Gelen response’un status kodunun 200
    Ve content type'inin "application/json"
    Ve Headers'daki "Server" in "cloudflare"
    Ve response body'deki "userId"'nin 7
    Ve "title" in "esse et quis iste est earum aut impedit"
    Ve "completed" bolumunun false oldugunu test edin.
 */

    @Test
    public void test() {

        String URL = "https://jsonplaceholder.typicode.com/todos/123";

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();


    }
}
