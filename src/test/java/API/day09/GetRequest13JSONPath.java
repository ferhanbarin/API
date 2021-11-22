package API.day09;

import API.TestBase.Dummy;
import API.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13JSONPath extends Dummy {

    @Test
    public void test() {

        spec03.pathParam("parametre1", "employees");

        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Object> expectedDataMap = expectedObje.setUpTestData();

        System.out.println(expectedDataMap);

        Response response = given().accept("application/json").spec(spec03).when().get("/{parametre1}");

        response.prettyPrint();


        JsonPath json = response.jsonPath();

        Assert.assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());
        Assert.assertEquals(expectedDataMap.get("besinciCalisan"), json.getString("data[4].employee_name"));
        Assert.assertEquals(expectedDataMap.get("calisanSayisi"), json.getList("data.id").size());
        Assert.assertEquals(expectedDataMap.get("sondanIkinciCalisanMaasi"), json.getInt("data[-2].employee_salary"));
        Assert.assertTrue(json.getList("data.employee_age").containsAll((Collection<?>) expectedDataMap.get("yaslar")));
        Assert.assertEquals(((Map)expectedDataMap.get("onbirinciCalisan")).get("id"), json.getInt("data[10].id"));
        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_name"), json.getString("data.employee_name"));
        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_salary"), json.getInt("data[10].employee_salary"));
        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_age"), json.getInt("data[10].employee_age"));
        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("profile_image"), json.getInt("data[10].profile_image"));
    }
}
