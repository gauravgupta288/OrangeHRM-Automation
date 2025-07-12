package com.orangehrm.framework.base;

import com.orangehrm.framework.specs.RequestSpecFactory;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class ApiTestSetup {
    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setupApi() {
        requestSpec = RequestSpecFactory.getDefaultSpec();
    }
}
