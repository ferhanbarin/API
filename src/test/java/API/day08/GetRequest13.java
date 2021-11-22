package API.day08;

import API.TestBase.Dummy;
import API.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


        // DE Serialization İslemi
        HashMap <String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        // Status kodunun 200 oldugunu test edin.
        Assert.assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());

        // 5. Calisan isminin "Airi Satou" oldugunu,
        Assert.assertEquals(expectedDataMap.get("besinciCalisan"), ((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name"));

        // Calisan sayisinin 24 oldugunu;
        Assert.assertEquals(expectedDataMap.get("calisanSayisi"), ((List<?>) actualDataMap.get("data")).size());

        // Sondan 2. calisanin maasinin 106450 oldugunu,

        // Once actual data'dan bize dönen List'in size'ini almaliyiz.
        int dataSize = ((List<?>) actualDataMap.get("data")).size();

        Assert.assertEquals(expectedDataMap.get("sondanIkinciCalisanMaasi"), ((Map)((List<?>) actualDataMap.get("data")).get(dataSize-2)).get("employee_salary"));

        // 40.21 ve 19 yaslarinda calisanlar olup olmadigini;
        List <Integer> actualYasListesi = new ArrayList<Integer>();

        for (int i=0; i<dataSize; i++) {
            actualYasListesi.add((Integer) ((Map) ((List<?>) actualDataMap.get("data")).get(i)).get("employee_age"));
        }

        Assert.assertTrue(actualYasListesi.containsAll((List)expectedDataMap.get("arananYaslar")));

    /*
        11. Calisan bilgilerinin
            "id": "11"
            "employee_name": "Jena Gaines",
                "employee_salary": "90560",
                "employee_age": "30",
                "profile_image": "" }
         gibi oldugunu test edin.
    */

        Assert.assertEquals(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_name"), ((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_name"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_salary"), ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("employee_salary"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_age"), ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("employee_age"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("profile_image"), ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("profile_image"));
    }
}
