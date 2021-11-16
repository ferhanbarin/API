package API.day08;

import API.TestBase.HerokuApp;
import API.testData.HerokuAppTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends HerokuApp {

/*
    https://restful-booker.herokuapp.com/booking/1 URL'ine bir istek gönderildiginde dönen response body'nin asagidaki gibi oldugunu test edin.

    "firstname": "Eric",
    "lastname": "Smith",
    "totalprice": 555,
    "depositpaid": false,
    "bookingdates": {
    "checkin": "2016-09-09",
    "checkout": "2017-09-21"
*/
    @Test
    public void test() {

        spec02.pathParams("parametre1", "booking", "parametre2", 1);

        // Expected Data
        HerokuAppTestData expectedObje = new HerokuAppTestData();
        HashMap <String, Object> expectedDataMap = expectedObje.setUpTestData();

        System.out.println(expectedDataMap);


        // Request Gönder
        Response response = given().accept("application/json").spec(spec02).when().get("/{parametre1}/{parametre2}");
        response.prettyPrint();


        // DE - Serialization
        HashMap <String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));

        Assert.assertEquals( ((Map)expectedDataMap.get("bookingdates")).get("checkin"),
                             ((Map)actualDataMap.get("bookingdates")).get("checkin"));

        Assert.assertEquals( ((Map)expectedDataMap.get("bookingdates")).get("checkout"),
                             ((Map)actualDataMap.get("bookingdates")).get("checkout"));

    }
}
