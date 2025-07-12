package com.orangehrm.tests.api;

import com.orangehrm.framework.base.ApiTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.List;
import static io.restassured.RestAssured.*;

public class OrangeHRMApiTest extends ApiTestSetup {

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
