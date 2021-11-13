package API.TestBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuApp {

    protected RequestSpecification spec02;

    @Before
    public void setup() {

        spec02 = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/booking/5").build();
    }
}