package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.my_requests.DeleteDepartmentMethod;
import com.qaprosoft.carina.demo.api.my_requests.GetDepartmentMethod;
import com.qaprosoft.carina.demo.api.my_requests.PostDepartmentMethod;
import com.qaprosoft.carina.demo.api.my_requests.PutDepartmentMethod;
import com.zebrunner.agent.core.annotation.Priority;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MyApiTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @Priority(Priority.P1)
    @MethodOwner(owner = "Vasyl Laba")
    public void testPostDepartment() {
        LOGGER.info("run testPostDepartment");
        PostDepartmentMethod postDepartment = new PostDepartmentMethod();
        postDepartment.callAPIExpectSuccess();
        postDepartment.validateResponse();
    }

    @Test(dependsOnMethods = "testPostDepartment")
    @Priority(Priority.P2)
    @MethodOwner(owner = "Vasyl Laba")
    public void testGetDepartment() {
        LOGGER.info("run testGetDepartment");
        GetDepartmentMethod getDepartmentMethod = new GetDepartmentMethod();
        getDepartmentMethod.addParameter("id", "4");
        getDepartmentMethod.callAPI();
        getDepartmentMethod.validateResponse();
    }

    @Test()
    @Priority(Priority.P3)
    @MethodOwner(owner = "Vasyl Laba")
    public void testPutDepartment() {
        LOGGER.info("run testPutDepartment");
        PutDepartmentMethod putDepartmentMethod = new PutDepartmentMethod();
        putDepartmentMethod.setProperties("api/departments/department-put.properties");
        putDepartmentMethod.request.pathParam("id", 4);
        putDepartmentMethod.callAPIExpectSuccess();
        putDepartmentMethod.validateResponse();
    }

    @Test(dependsOnMethods = {"testGetDepartment", "testPutDepartment"})
    @Priority(Priority.P5)
    @MethodOwner(owner = "Vasyl Laba")
    public void testDeleteDepartment() {
        LOGGER.info("run testDeleteDepartment");
        DeleteDepartmentMethod deleteDepartmentMethod = new DeleteDepartmentMethod();
        deleteDepartmentMethod.callAPIExpectSuccess();
        deleteDepartmentMethod.validateResponse();
    }

}
