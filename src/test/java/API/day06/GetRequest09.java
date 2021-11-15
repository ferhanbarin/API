package API.day06;

import API.TestBase.Dummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest09 extends Dummy {

/*
    http://dummy.restapiexample.com/api/v1/employees URL'ine bir istek gönderildiginde,
    status kodun 200,
    gelen body de,
    5. calısanın isminin "Airi Satou" oldugunu,
    6. calısanın maasının "372000" oldugunu,
    Toplam 24 tane çalışan olduğunu,
    "Rhona Davidson" ın employee'lerden biri oldugunu
    "21", "23", "61" yaslarında employeeler oldugunu test edin.
*/

    @Test
    public void test() {

        spec03.pathParam("parametre1", "employees");

        Response response = given().accept("application/json").spec(spec03).when().get("/{parametre1}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(200, response.getStatusCode());

        System.out.println(jsonPath.getList("data.id").size());
        Assert.assertEquals(24, jsonPath.getList("data.id").size());
        Assert.assertEquals("Airi Satou", jsonPath.getString("data[4].employee_name"));
        Assert.assertEquals(37200, jsonPath.getInt("data[5].employee_salary"));

        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));

        List<Integer> arananYaslar = Arrays.asList(21,23,61);
        arananYaslar.add(21);
        arananYaslar.add(23);
        arananYaslar.add(61);

        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(arananYaslar));
    }
}
