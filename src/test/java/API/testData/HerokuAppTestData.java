package API.testData;

import org.json.JSONObject;

import java.util.HashMap;

public class HerokuAppTestData {

    public HashMap <String, Object> setUpTestData() {

        HashMap <String, Object> bookingdates = new HashMap<String, Object>();

        bookingdates.put("checkin", "2016-07-28");
        bookingdates.put("checkout", "2020-03-26");

        HashMap <String, Object> expectedData = new HashMap<String, Object>();

        expectedData.put("firstname", "Sally");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 716);
        expectedData.put("depositpaid", false);
        expectedData.put("bookingdates", bookingdates);

        return expectedData;
    }


    public JSONObject setUpTestAndRequestData() {

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2020-09-09");
        bookingdates.put("checkout", "2020-09-21");

        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("firstname", "Ferhan");
        expectedRequest.put("lastname", "Oguz");
        expectedRequest.put("totalprice", 123);
        expectedRequest.put("depositpaid", false);
        expectedRequest.put("bookingdates", bookingdates);

        return expectedRequest;
    }
}
