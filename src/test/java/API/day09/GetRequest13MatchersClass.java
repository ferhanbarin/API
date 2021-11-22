package API.day09;

import API.TestBase.Dummy;
import API.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest13MatchersClass extends Dummy {

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
        HashMap<String, Object> expectedDataMap = expectedObje.setUpTestData();

        System.out.println(expectedDataMap);

        Response response = given().accept("application/json").spec(spec03).when().get("/{parametre1}");

        response.prettyPrint();

        response.then().assertThat().statusCode((Integer) expectedDataMap.get("statusCode"))
                .body("data[4].employee_name", equalTo(expectedDataMap.get("besinciCalisan")),
                        "data.id", hasSize((Integer) expectedDataMap.get("calisanSayisi")),
                        "data[-2].employee_salary", equalTo(expectedDataMap.get("sondanIkinciCalisanMaasi")),
                        "data.employee_age", hasItems(((List)expectedDataMap.get("yaslar")).get(0), ((List<?>) expectedDataMap.get("yaslar")).get(1), ((List<?>) expectedDataMap.get("yaslar")).get(2)),
                        "data[10].employee_name", equalTo(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_name")),
                        "data[10].employee_salary", equalTo(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_salary")),
                        "data[10].employee_age", equalTo(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_age")),
                        "data[10].profile_image", equalTo(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("profile_image")));
    }
}
