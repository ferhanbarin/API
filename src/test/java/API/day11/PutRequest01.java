package API.day11;

import API.TestBase.JsonPlaceHolder;
import API.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends JsonPlaceHolder {

/*
    https://jsonplaceholder.typicode.com/todos/198 URL'ine aşagidaki body gönerdigimde
    {
      "userId": 21,
      "title": "Wash the dishes",
      "completed": false
     }
    Dönen response un status kodunun 200 ve body kısmının asagidaki gibi oldugunu test edin
    {
    "userId": 21,
    "title": "Wash the dishes",
    "completed": false,
    "id": 198
    }
*/

    @Test
    public void test() {

        spec01.pathParams("parametre1", "todos", "parametre2", 198);

        JsonPlaceHolderTestData testObject = new JsonPlaceHolderTestData();
        JSONObject expectedRequest = testObject.setUpPutData();
        System.out.println(expectedRequest);

        Response response = given().contentType(ContentType.JSON).spec(spec01).auth().basic("admin", "password123").body(expectedRequest.toString()).when().put("/{parametre1}/{parametre2}");
        response.prettyPrint();

        // JSONPath
        JsonPath json = response.jsonPath();

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(expectedRequest.getInt("userId"), json.getInt("userId"));
        Assert.assertEquals(expectedRequest.getString("title"), json.getString("title"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"), json.getBoolean("completed"));
    }
}
