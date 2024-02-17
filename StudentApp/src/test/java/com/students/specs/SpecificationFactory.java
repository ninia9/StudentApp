package com.students.specs;

import com.students.tests.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class SpecificationFactory extends TestBase {


    public static synchronized ResponseSpecification getGenericResponseSpec(){

        ResponseSpecBuilder responceSpec;
        ResponseSpecification responseSpecification;

        responceSpec = new ResponseSpecBuilder();
        responceSpec.expectHeader("Content-Type", "application/json");
        responceSpec.expectHeader("Transfer-Encoding", "chunked");
        responceSpec.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);

        responseSpecification = responceSpec.build();

        return  responseSpecification;

    }

    public static synchronized RequestSpecification logPayloadResponseInfo(){
        RequestSpecBuilder logBuilder;
        RequestSpecification logSpecification;

        logBuilder = new RequestSpecBuilder();
        logBuilder.addFilter(new AllureRestAssured());

        if(prop.getProperty("log").equals("ENABLE")){
            logBuilder.addFilter(new AllureRestAssured());
        }

        logSpecification = logBuilder.build();

        return logSpecification;
    }

}
