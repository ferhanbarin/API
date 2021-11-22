package API.day09;

import API.TestBase.Dummy;
import API.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;
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

        // DE Serialization Yöntemi ile;
        HashMap <String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        // Status code 200 oldugunu,
        Assert.assertEquals(expectedDataMap.get("statusCode"), (Integer) response.getStatusCode());

        // En yüksek maasin 725000 oldugunu,
        List<Integer> maasListesi = new ArrayList<Integer>();
        int dataSize = ((List)actualDataMap.get("data")).size();

        for (int i=0; i<dataSize; i++) {

           maasListesi.add((Integer) ((Map) ((List)actualDataMap.get("data")).get(i)).get("employee_salary"));
        }

        Collections.sort(maasListesi);
        Assert.assertEquals(expectedDataMap.get("enYuksekMaas"), maasListesi.get(dataSize-1));

        // Ikinci en yüksek maasin 675000 oldugunu,
        Assert.assertEquals(expectedDataMap.get("ikinciEnYüksekMaas"), maasListesi.get(maasListesi.size()-2));

        // En kücük yasin 19 oldugunu,
        List <Integer> yasListesi = new ArrayList<Integer>();

        for (int i=0; i<dataSize; i++) {

           yasListesi.add((Integer) ((Map)((List<?>) actualDataMap.get("data")).get(i)).get("employee_age"));
        }

        Collections.sort(yasListesi);
        Assert.assertEquals(expectedDataMap.get("enKücükYas"), yasListesi.get(0));


        // JSON Path yöntemi ile;
        JsonPath json = response.jsonPath();

        // En yüksek maasin 725000 oldugunu,
        List <Integer> maasListesijson = json.getList("data.employee_salary");
        Collections.sort(maasListesijson);
        Assert.assertEquals(expectedDataMap.get("enYüksekMaas"), maasListesijson.get(maasListesijson.size()-1));
        Assert.assertEquals(expectedDataMap.get("ikinciEnYüksekMaas"), maasListesijson.get(maasListesijson.size()-2));

        // En kücük yasin 19 oldugunu,
        List <Integer> yasListesijson = json.getList("data.employee_age");
        Collections.sort(yasListesijson);
        Assert.assertEquals(expectedDataMap.get("enKücükYas"), yasListesijson.get(0));
    }
}
