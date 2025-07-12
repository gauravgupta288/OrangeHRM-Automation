package com.orangehrm.tests.api;

import com.orangehrm.framework.base.ApiTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasKey;

public class OrangeHRMApiTest extends ApiTestSetup {

    @Test
    public void userTest() {

        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/web/index.php/api/v2/admin/users?limit=50&offset=0&sortField=u.userName&sortOrder=ASC")
                .then()
                .extract().response();

        System.out.println("Response JSON:");
        System.out.println(response.prettyPrint());

        List<Map<String, Object>> emp = response.jsonPath().getList("data.employee");

        System.out.println(emp);

        Map<String, Object> filteredUser = emp
                .stream()
                .filter(e -> e.get("empNumber").equals(547))
                .findFirst()
                .orElse(null);

        Map<Integer, Map<String, Object>> user = emp
                .stream()
                .distinct()
                        .collect(Collectors.toMap(e -> (Integer)e.get("empNumber"), e -> e));

        System.out.println(user);
        System.out.println(filteredUser);
    }

    @Test
    public void userTestSchemaValidation() {

        given()
                .spec(requestSpec)
                .when()
                .get("/web/index.php/api/v2/admin/users?limit=50&offset=0&sortField=u.userName&sortOrder=ASC")
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("users-schema.json"));
    }

    @Test
    public void userTestFieldsValidation() {

        given()
                .spec(requestSpec)
                .when()
                .get("/web/index.php/api/v2/admin/users?limit=50&offset=0&sortField=u.userName&sortOrder=ASC")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data[0].employee", allOf(
                        hasKey("empNumber"),
                        hasKey("employeeId"),
                        hasKey("firstName"),
                        hasKey("terminationI")
                ))
                ;
    }
}
