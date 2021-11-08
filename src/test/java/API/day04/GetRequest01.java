package API.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetRequest01 {

/*
    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde dönecek cevap (response) icin.
    HTTP status kodunun 200
    Content Type'in Json ve Status Line'in HTTP/1.1 200 OK
    Oldugunu test edin.
*/

    @Test
    public void test01() {

    // 1- API testi yaparken ilk olarak URL (Endpoint) belirlenmelidir.

        String URL = "https://restful-booker.herokuapp.com/booking/3";

    // 2- Beklenen sonuc (Expected Result) olusturulur.
    //    Bu case'de benden body dogrulamasi istenmedigi icin simdilik beklenen sonuc olusturmuyoruz.
    // 3- Request gönder.

        Response response = given().accept("application/json").when().get(URL);

        response.prettyPrint();

    // 4- Actual result olustur.
    //    Response body ile ilgili islem yapmayacagimiz icin simdilik olusturmayacagiz.
    // 5- Dogrulama yap. (Assertion)

        System.out.println("Status code : " + response.getStatusCode()); // Response'den gelen status code verir.
        System.out.println("Content type : " + response.getContentType()); // Response'den gelen content type verir.
        System.out.println("Status line : " + response.getStatusLine()); // Response'den gelen status line verir.

        System.out.println("response.getHeaders() = " + response.getHeaders());
    /*
        Assert.assertEquals(200, response.getStatusCode());
        // Expected kismi bize tast olarak verilen degerdir, actual kismi ise response'dan dönen degerdir.
        // Status code int deger döndürür.

        Assert.assertEquals("application/json; charset=utf-8", response.getContentType());
        Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
    */

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
    }
}
