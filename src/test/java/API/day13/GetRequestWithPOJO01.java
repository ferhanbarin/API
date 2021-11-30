package API.day13;

import API.POJOS.Data;
import API.POJOS.DummyPOJO;
import API.TestBase.Dummy;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetRequestWithPOJO01 extends Dummy {

/*
    http://dummy.restapiexample.com/api/v1/employee/1 url ‘ine bir get request gönderildiğinde , dönen response ‘un,
    Status kodunun 200 ve response body’nin
    {
        "status": "success",
        "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
    }
    Oldugunu test edin.
*/

    @Test
    public void test() {

        spec03.pathParams("parametre1", "employee", "parametre2", 1);

        Data data = new Data(1, "Tiger Nixon", 320800, 61, "");
        DummyPOJO expectedData = new DummyPOJO("success", data, "Successfully! Record has been fetched.");

        Response response = given().contentType(ContentType.JSON).spec(spec03).when().get("/{parametre1}/{parametre2}");
        response.prettyPrint();

        DummyPOJO actualData = response.as(DummyPOJO.class);
        System.out.println(actualData);





    }

}
