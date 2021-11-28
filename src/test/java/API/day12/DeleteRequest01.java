package API.day12;

import API.TestBase.Dummy;
import API.testData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequest01 extends Dummy {

/*
    http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdigimde

    Dönen response'un status kodunun 200 ve body kisminin asagidaki gibi oldugunu test edin.
    {
    "status": "success",
    "data": "2",
    "message": "Successfully! Record has been deleted"
    }
*/

    @Test
    public void test() {

        // URL
        spec03.pathParams("parametre1", "delete", "parametre2", 2);

        DummyTestData testData = new DummyTestData();
        JSONObject expectedData = testData.setUpDeleteExpectedData();

        Response response = given().contentType(ContentType.JSON).spec(spec03).auth().basic("admin", "password123").when().delete("/{parametre1}/{parametre2}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200)
                .body("status", equalTo(expectedData.getString("status")),
                        "data", equalTo(expectedData.getString("data")),
                        "message", equalTo(expectedData.getString("message")));
    }
}
