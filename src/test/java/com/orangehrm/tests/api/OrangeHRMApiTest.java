package com.orangehrm.tests.api;

import com.orangehrm.framework.base.ApiTestSetup;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

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

        Response res=given()
                .spec(requestSpec)
                .header("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave")
                .when()
                .get("/web/index.php/api/v2/leave/holidays?fromDate=2025-01-01&toDate=2025-12-31")
                .then()
                .statusCode(200)
                .assertThat()
//                .body("data[0].employee", allOf(
//                        hasKey("empNumber"),
//                        hasKey("employeeId"),
//                        hasKey("firstName"),
//                        hasKey("terminationId")
//                ))
                .extract()
                .response()
                ;

        System.out.println(res.asPrettyString());
        JsonPath jsonPath = new JsonPath(res.asString());

        List<Map<Integer, Object>> list = jsonPath.getList("data");
        System.out.println(jsonPath);
        boolean found = false;

        for(Map<Integer, Object> item : list){

            Object id = item.get("id");
            Object name = item.get("name");

            Assert.assertTrue(id != null);


            if(id != null && id.equals(11)){
                Assert.assertEquals(name, "St. Patrick's Day (Canada)");
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "mathicing id not found");
    }

    @Test
    public void userTestFieldsValidationWithPojo() {

        Response res=given()
                .spec(requestSpec)
                .header("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave")
                .when()
                .get("/web/index.php/api/v2/leave/holidays?fromDate=2025-01-01&toDate=2025-12-31")
                .then()
                .statusCode(200)
                .assertThat()
//                .body("data[0].employee", allOf(
//                        hasKey("empNumber"),
//                        hasKey("employeeId"),
//                        hasKey("firstName"),
//                        hasKey("terminationId")
//                ))
                .extract()
                .response()
                ;

        System.out.println(res.asPrettyString());
        JsonPath jsonPath = new JsonPath(res.asString());

        List<Map<Integer, Object>> list = jsonPath.getList("data");
        System.out.println(jsonPath);
        boolean found = false;

        for(Map<Integer, Object> item : list){

            Object id = item.get("id");
            Object name = item.get("name");

            Assert.assertTrue(id != null);


            if(id != null && id.equals(11)){
                Assert.assertEquals(name, "St. Patrick's Day (Canada)");
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, "mathicing id not found");
    }

    @Test
    public void postMethod() {

        String body = """
        {
            "username" : "test",
            "password" : "pass"
        }
        """;
        Response res = given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/user")
                .then()
                .statusCode(201)
                .body("data.name", equalTo("gaurav"))
                .body("data.id", notNullValue())
                .extract()
                .response()
                ;


        JsonPath jsonPath = new JsonPath(res.toString());


    }
}
