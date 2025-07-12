package com.orangehrm.tests.api;

import com.orangehrm.framework.ResponseSpecification.ResponseSpecification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.List;
import static io.restassured.RestAssured.*;

public class OrangeHRMApiTest {

    RequestSpecification requestSpec;

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com";

        requestSpec = given()
                .header("Accept", "application/json")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0")
                .header("Connection", "keep-alive")
                .header("DNT", "1")
                .header("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers")
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"137\", \"Chromium\";v=\"137\", \"Not/A)Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "\"Windows\"")
                .cookie("orangehrm", "38oebkjsh9tna13b5h5uf4dgc0");
    }
    @Test
    public void userTest() {


        Response  response = given()
                .spec(requestSpec)
                .when()
                .get("/web/index.php/api/v2/admin/users?limit=50&offset=0&sortField=u.userName&sortOrder=ASC")
                .then()
                .extract().response();

        System.out.println("Response JSON:");
        System.out.println(response.prettyPrint());

        List<Map<String, Object>> emp = response.jsonPath().getList("data.employee");

        System.out.println(emp);
    }
}
