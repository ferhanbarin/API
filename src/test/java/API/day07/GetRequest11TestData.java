package API.day07;

import API.TestBase.JsonPlaceHolder;
import API.testData.JsonPlaceHolderTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest11TestData extends JsonPlaceHolder {

    @Test
    public void test() {

        spec01.pathParams("parametre1", "todos",
                "parametre2", 2);

        JsonPlaceHolderTestData expectedObje = new JsonPlaceHolderTestData();
        HashMap <String, Object> expectedData = (HashMap<String, Object>) expectedObje.setUpTestData();
        System.out.println(expectedData);

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
