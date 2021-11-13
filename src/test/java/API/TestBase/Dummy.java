package API.TestBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Dummy {

    protected RequestSpecification spec03;

    @Before
    public void setup() {

        spec03 = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1/employees").build();
    }
}
