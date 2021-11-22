package API.day09;

import API.TestBase.Dummy;
import API.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends Dummy {

/*
    http://dummy.restapiexample.com/api/v1/employees URL'ine bir istek gönderildiginde
    Status kodun 200 oldugunu,
    En yüksek maasin 725000 oldugunu,
    En küçük yasin 19 oldugunu,
    Ikinci en yüksek maasin 675000
    oldugunu test edin.
*/

    @Test
    public void test() {

        spec03.pathParam("parametre1", "employees");

        DummyTestData expectedObje = new DummyTestData();
        HashMap <String, Integer> expectedDataMap = expectedObje.setUpTestData2();
        System.out.println(expectedDataMap);

        Response response = given().accept("application/json").spec(spec03).when().get("/{parametre1}");

        response.prettyPrint();
    }
}
