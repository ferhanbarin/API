package API.day10;

import API.TestBase.HerokuApp;
import API.testData.HerokuAppTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends HerokuApp {

/*
    https://restful-booker.herokuapp.com/booking URL'ine, Request Body olarak
    { "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 11111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
    }
    gönderildiginde, Status kodun 200 oldugunu ve dönen response body'nin,
    "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2020-09-01",
              "checkout": " 2020-09-21”
         },
        }
    oldugunu test edin.
*/

    @Test
    public void test() {

        // URL
        spec02.pathParam("parametre1", "booking");


        // Request Body & Expected Data --> Ayni oldugu icin tek bir JSONObject kullanilmasi yeterlidir.
        HerokuAppTestData testData = new HerokuAppTestData();
        JSONObject expectedRequestData = testData.setUpTestAndRequestData();
        System.out.println(expectedRequestData);


        // Request gönder,
        Response response = given().contentType(ContentType.JSON).spec(spec02).auth().basic("admin", "password123").body(expectedRequestData.toString()).when().post("/{parametre1}");
        response.prettyPrint();


        // DE Serialization Yöntemi
        HashMap <String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedRequestData.getString("firstname"), ((Map)actualDataMap.get("booking")).get("firstname"));
        Assert.assertEquals(expectedRequestData.getString("lastname"), ((Map)actualDataMap.get("booking")).get("lastname"));

        Assert.assertEquals(expectedRequestData.getInt("totalprice"), ((Map<?, ?>) actualDataMap.get("booking")).get("totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid"), ((Map<?, ?>) actualDataMap.get("booking")).get("depositpaid"));

        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkin"), ((Map)((Map<?, ?>) actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkout"), ((Map)((Map<?, ?>) actualDataMap.get("booking")).get("bookingdates")).get("checkout"));



        // JSON Path Yöntemi
        JsonPath json = response.jsonPath();

        Assert.assertEquals(expectedRequestData.getString("firstname"), json.getString("booking.firstname"));
        Assert.assertEquals(expectedRequestData.getString("lastname"), json.getString("booking.lastname"));

        Assert.assertEquals(expectedRequestData.getInt("totalprice"), json.getInt("booking.totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid"), json.getBoolean("booking.depositpaid"));

        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkin"), json.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkout"), json.getString("booking.bookingdates.checkout"));
    }
}
