package API.testData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {

    public HashMap <String, Object> setUpTestData() {

        List <Integer> yaslar = new ArrayList <Integer>();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);


        HashMap <String, Object> calisanBilgileri11 = new HashMap<String, Object>();
        calisanBilgileri11.put("id", 11);
        calisanBilgileri11.put("employee_name", "Jena Gaines");
        calisanBilgileri11.put("employee_salary", 90560);
        calisanBilgileri11.put("employee_age", 30);
        calisanBilgileri11.put("profile_image", "");


        HashMap <String, Object> expectedData = new HashMap <String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("besinciCalisan", "Airi Satou");
        expectedData.put("calisanSayisi", 24);
        expectedData.put("sondanIkinciCalisanMaasi", 106450);
        expectedData.put("arananYaslar", yaslar);
        expectedData.put("onbirinciCalisan", calisanBilgileri11);

        return expectedData;
    }


    public HashMap <String, Integer> setUpTestData2() {

        HashMap <String, Integer> expectedDataMap = new HashMap<String, Integer>();
        expectedDataMap.put("statusCode", 200);
        expectedDataMap.put("enYüksekMaas", 725000);
        expectedDataMap.put("enKücükYas", 19);
        expectedDataMap.put("ikinciEnYüksekMaas", 675000);

        return expectedDataMap;
    }


    public HashMap <String, String> setupRequestBody() {

        HashMap <String, String> requestBody = new HashMap<String, String>();
        requestBody.put("name", "Oguz Ferhan");
        requestBody.put("salary", "100000");
        requestBody.put("age", "25");

        return requestBody;
    }


    public HashMap <String, Object> setUpExpectedData() {

        HashMap <String, Object> data = new HashMap<String, Object>();
        data.put("name", "Oguz Ferhan");
        data.put("salary", "100000");
        data.put("age", "25");

        HashMap <String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("status", "success");
        expectedData.put("message", "Successfully! Record has been added.");

        return expectedData;
    }


    public JSONObject setUpDeleteExpectedData() {

        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", "2");
        expectedData.put("message", "Successfully! Record has been deleted");

        return expectedData;
    }
}
