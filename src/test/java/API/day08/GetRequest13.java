package API.day08;

import API.TestBase.Dummy;
import API.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends Dummy {

/*
    http://dummy.restapiexample.com/api/v1/employees URL'ine bir istek gönderildiginde
    Status kodun 200 oldugunu,
    5. Calisan isminin "Airi Satou" oldugunu, calisan sayisinin 24 oldugunu,
    Sondan 2. calisanin maasinin 106450 oldugunu
    40,21 ve 19 yaslarinda calisanlar olup olmadigini
    11. Calisan bilgilerinin
    {
    "id": "11"
    "employee_name": "Jena Gaines",
    "employee_salary": "90560",
    "employee_age": "30",
    "profile_image": "" }
    } gibi oldugunu test edin.
*/

    @Test
    public void test() {

        spec03.pathParam("parametre1", "employees");

        DummyTestData expectedObje = new DummyTestData();
        HashMap <String, Object> expectedDataMap = expectedObje.setUpTestData();

        System.out.println(expectedDataMap);

        Response response = given().accept("application/json").spec(spec03).when().get("/{parametre1}");

        response.prettyPrint();
    }
}
