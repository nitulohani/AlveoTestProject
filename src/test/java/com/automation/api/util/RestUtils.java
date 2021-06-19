package com.automation.api.util;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response getEndpointIsHit(String endpoint) {
       return given()
                .when()
                .get(endpoint);
    }

    public static Response postEndpointIsHit(String endpoint, String payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    public static Response deleteEndpointIsHit(String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .delete(endpoint);
    }

    public static Response deleteEndpointIsHitWithPayload(String endpoint, String payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .delete(endpoint);
    }
}