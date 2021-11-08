package API.day04;

import io.restassured.response.Response;
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

    // 4- Actual result olustur.
    // 5- Dogrulama yap. (Assertion)

        response.prettyPrint();
    }
}
