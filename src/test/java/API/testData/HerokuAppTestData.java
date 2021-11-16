package API.testData;

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
}
