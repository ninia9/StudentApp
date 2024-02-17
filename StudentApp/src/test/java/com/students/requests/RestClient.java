package com.students.requests;

import com.students.specs.SpecificationFactory;
import com.students.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RestClient extends TestBase {

    public Response doGetRequest(String requestPath){
        Response response =  RestAssured.given()
                .spec(SpecificationFactory.logPayloadResponseInfo())
                    .when()
                    .get(requestPath);
        return response;
    }

    public Response doPostRequest(String uri, Object body){
        Response response = given()
                .contentType(ContentType.JSON)
                .spec(SpecificationFactory.logPayloadResponseInfo())
                .when()
                .body(body)
                .post(uri);
        return response;
    }

    public Response doPutRequest(String res, Object body){
        Response response = given()
                            .when()
                            .body(body)
                            .put(res);
        return response;
    }

    public Response doPatchRequest(String res, Object body){
        Response response = given()
                            .when()
                            .body(body)
                            .patch(res);
        return response;
    }

    public Response doDeleteRequest(String res) {
        Response response = given()
                            .when()
                            .delete(res);
        return response;
    }
}
