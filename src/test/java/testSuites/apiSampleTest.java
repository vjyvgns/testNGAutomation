package test.java.testSuites;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class apiSampleTest {

    @Test
    public void Test_01(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
