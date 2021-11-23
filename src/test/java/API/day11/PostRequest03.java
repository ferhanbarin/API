package API.day11;

import API.TestBase.JsonPlaceHolder;
import API.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest03 extends JsonPlaceHolder {

/*
    https://jsonplaceholder.typicode.com/todos URL'ine asagidaki body gönderildiginde,
     }
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
    }
    Dönen response un Status kodunun 201 ve response body'nin asagidaki gibi oldugunu test edin.
    {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }
*/

    @Test
    public void test() {

        spec01.pathParam("parametre1", "todos");

        JsonPlaceHolderTestData testObje = new JsonPlaceHolderTestData();
        JSONObject expectedRequest = testObje.setUpPostData();
        System.out.println(expectedRequest);

        Response response = given().contentType(ContentType.JSON).spec(spec01).auth().basic("admin", "password123").body(expectedRequest.toString()).when().post("/{parametre1}");
        response.prettyPrint();


        // Matcher Class
        response.then().assertThat().statusCode((Integer)(expectedRequest.get("statusCode")))
                .body("completed", equalTo(expectedRequest.getString("completed")),
                        "title", equalTo(expectedRequest.getString("title")),
                        "userId", equalTo(expectedRequest.getInt("userId")));

        // JSONPath ile,
        JsonPath json = response.jsonPath();

        Assert.assertEquals(expectedRequest.getInt("statusCode"), response.getStatusCode());
        Assert.assertEquals(expectedRequest.getInt("userId"), json.getInt("userId"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"), json.getBoolean("completed"));


        // DE Serialization
        HashMap <String, Object> actualDataMap = response.as(HashMap.class);

        Assert.assertEquals(expectedRequest.getString("title"), actualDataMap.get("title"));
        Assert.assertEquals(expectedRequest.getInt("userId"), actualDataMap.get("userId"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"), actualDataMap.get("completed"));
    }
}
