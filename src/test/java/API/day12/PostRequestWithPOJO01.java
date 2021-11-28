package API.day12;

import API.POJOS.TodosPOJO;
import API.TestBase.JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class PostRequestWithPOJO01 extends JsonPlaceHolder {

/*
    https://jsonplaceholder.typicode.com/todos URL'ine bir request gönderildiginde
    Request body {
                  "userId": 21,
                  "id": 201,
                  "title": "Tidy your room",
                  "completed": false
                }
    Status kodun 201, response body ‘nin ise
    {
                  "userId": 21,
                  "id": 201,
                  "title": "Tidy your room",
                  "completed": false
                }
*/

    @Test
    public void test() {

        spec01.pathParam("parametre1", "todos");

        TodosPOJO requestExpected = new TodosPOJO(21, 201, "Tidy your room", false);
        System.out.println(requestExpected);

        Response response = given().contentType(ContentType.JSON).spec(spec01).auth().basic("admin", "password123").body(requestExpected).when().post("/{parametre1}");
        response.prettyPrint();


        // DE Serialization
        TodosPOJO actualData = response.as(TodosPOJO.class);

        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals(requestExpected.getUserId(), actualData.getUserId());
        Assert.assertEquals(requestExpected.getId(), actualData.getId());
        Assert.assertEquals(requestExpected.getTitle(), actualData.getTitle());
        Assert.assertEquals(requestExpected.isCompleted(), actualData.isCompleted());
    }
}
