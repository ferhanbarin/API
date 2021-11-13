package API.day05;

import API.TestBase.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 extends JsonPlaceHolder {

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

        // String URL = "https://jsonplaceholder.typicode.com/todos/123";
        spec01.pathParams("parametre1", "todos", "parametre2", 123);

        Response response = given().accept("application/json").spec(spec01).when().get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json")
                .header("Server", equalTo("cloudflare"))
                .body("userId", equalTo(7),
                        "title", equalTo("esse et quis iste est earum aut impedit"),
                        "completed", equalTo(false));
    }
}
