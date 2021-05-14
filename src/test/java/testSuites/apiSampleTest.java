package test.java.testSuites;

import main.java.utils.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class apiSampleTest extends BaseTest {

    @DataProvider(name="testData")
    public Object[][] getTestData(){
        String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
        return testRecords;
    }

    @Test
    public void Test_01() {
        baseURI = "https://reqres.in";
        //Get Request
        given().
            get("/api/users?page=2").
        then().
            statusCode(200).
            log().all();

        //Creating a body json
        HashMap<String,Object> map = new HashMap<String,Object> ();
        map.put("Name","Vijay");

        JSONObject json = new JSONObject(map);
        System.out.println(json);

        //Post Request
        given().
            body(json.toJSONString()).
        when().
            post("/api/users").
        then().
            statusCode(201).
            log().all();

        //Put Request

        given().
            body(json.toJSONString()).
        when().
            put("/api/users/2").
        then().
            statusCode(200).
            log().all();
    }
}
