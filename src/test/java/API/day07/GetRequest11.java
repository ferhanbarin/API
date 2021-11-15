package API.day07;

import API.TestBase.JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest11 extends JsonPlaceHolder {

/*
    https://jsonplaceholder.typicode.com/todos/2 URL‘ine istek gönderildiginde,
    Dönen response'un
    Status kodunun 200, dönen body de,
    "completed": degerinin false
    "title": degerinin "quis ut nam facilis et officia qui"
    "userId" sinin 1 ve header degerlerinden
    "Via" degerinin "1.1 vegur" ve
    "Server" degerinin "cloudflare" oldugunu test edin…
*/

    @Test
    public void test() {

        spec01.pathParams("parametre1", "todos",
                     "parametre2", 2);

        HashMap <String, Object> expectedData = new HashMap <String, Object>();

        expectedData.put("statusCode", 200);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("userId", 1);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("Completed", false);

        System.out.println(expectedData);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        Response response = given().accept("application/json").spec(spec01).when().get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        // I. Yöntem Matchers class ile Assertion islemi yaptik.

        response.then().assertThat().statusCode((Integer) expectedData.get("statusCode"))
                .headers("via", equalTo(expectedData.get("Via")),
                        "Server", equalTo(expectedData.get("Server")))
                .body("userId", equalTo(expectedData.get("userId")),
                        "title", equalTo(expectedData.get("title")),
                        "completed", equalTo(expectedData.get("completed")));

        // II. Yöntem

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(response.statusCode(), expectedData.get("statusCode"));
        Assert.assertEquals(expectedData.get("Via"), response.header("Via"));
        Assert.assertEquals(expectedData.get("Server"), response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"), jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"), jsonPath.getString("title"));
        Assert.assertEquals(expectedData.get("completed"), jsonPath.getBoolean("completed"));




    }
}
