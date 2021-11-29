package API.day12;

import API.POJOS.BookingDatesPOJO;
import API.POJOS.BookingPOJO;
import API.POJOS.BookingResponsePOJO;
import API.TestBase.HerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithPOJO02 extends HerokuApp {

/*
    https://restful-booker.herokuapp.com/booking
    URL'ine asagidaki request body gönderildiginde,
    {
               "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 15000,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
    } Status kodun 200 ve dönen response ‘un
    {
                         "bookingid": 11,
                         "booking": {
                             "firstname": "Selim",
                             "lastname": "Ak",
                             "totalprice": 15000,
                             "depositpaid": true,
                             "bookingdates": {
                                 "checkin": "2020-09-09",
                                 "checkout": "2020-09-21"
                             }
                         }
                      } oldugunu test edin.
*/

    @Test
    public void test() {

        spec02.pathParam("parametre1", "booking");

        BookingDatesPOJO bookingdates = new BookingDatesPOJO("2020-09-09", "2020-09-21");
        BookingPOJO bookingPojo = new BookingPOJO("Selim", "Ak", 15000, true, bookingdates);

        Response response = given().contentType(ContentType.JSON).spec(spec02).auth().basic("admin", "password123").body(bookingPojo).post("/{parametre}");
        response.prettyPrint();

        BookingResponsePOJO actualData = response.as(BookingResponsePOJO.class);

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(bookingPojo.getFirstname(), actualData.getBooking().getFirstname());
        Assert.assertEquals(bookingPojo.getLastname(), actualData.getBooking().getLastname());
        Assert.assertEquals(bookingPojo.getTotalprice(), actualData.getBooking().getTotalprice());
        Assert.assertEquals(bookingPojo.isDepositpad(), actualData.getBooking().isDepositpad());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
    }
}
