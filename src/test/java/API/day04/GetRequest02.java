package API.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetRequest02 {

/*
    https://restful-booker.herokuapp.com/booking URL'ine;
    Accept type'i "application/json" olan GET request'i yolladigimda gelen response'un status kodunun 200 content type'inin "application/json" oldugunu test edildi.
*/

    @Test
    public void test1() {

        String URL = "https://restful-booker.herokuapp.com/booking";

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json");
    }

    @Test
    public void test2() {
/*
        https://restful-booker.herokuapp.com/booking/1001 URL'ine
        Accept type'i "application/json" olan GET request'i yolladigimda gelen response'un status kodunun 404 oldugunu ve
        Response body'sinin "Not Found" icerdigini ve Response body'sinin "API" icermedigini test edin.
*/

        String URL = "https://restful-booker.herokuapp.com/booking/1001";

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();

        response.then().assertThat().statusCode(404);

        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("API"));

        // asString() method'u ile JSON formatinda gelen response'yi String'e cevirdik.
    }
}
