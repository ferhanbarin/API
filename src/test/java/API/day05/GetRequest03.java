package API.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {

/*
    https://restful-booker.herokuapp.com/booking/7 URL'ine accept type'i "application/json" olan GET request'i yolladigimda gelen response'un status kodunun 200
    ve content type'inin "application/json" ve firstname'in "Sally" ve lastname'in "Ericsson" ve checkin date'in 2018-10-07" ve checkout date'in 2020-09-30 oldugunu test edin.
*/

    @Test
    public void test() {

        String URL = "https://restful-booker.herokuapp.com/booking/7";

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();

    /*
        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("firstname", Matchers.equalTo("Susan"))
                .body("lastname", Matchers.equalTo("Jackson"))
                .body("totalprice", Matchers.equalTo(811))
                .body("depositpaid", Matchers.equalTo(true))
                .body("bookingdates.checkin", Matchers.equalTo("2021-08-11"))
                .body("bookingdates.checkout", Matchers.equalTo("2021-10-18"));

    */

        // II. YOL
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", equalTo("Susan"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", equalTo(811),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2021-08-11"),
                        "bookingdates.checkout", equalTo("2021-10-18"));
    }
}
