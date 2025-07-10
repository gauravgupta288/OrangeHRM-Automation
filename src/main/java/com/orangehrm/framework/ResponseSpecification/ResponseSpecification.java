package com.orangehrm.framework.ResponseSpecification;

import io.restassured.RestAssured;

public class ResponseSpecification {
    public void responseSpecification(){
        RestAssured
                .given()
                .then()
                .statusCode(200);
    }
}
