package com.devex.tag_03;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class QueryParams {
    // endpoint'in parcasi degildir

    String devexUrl = "http://www.eurotech.study";
    String psUrl = "http://petstore.swagger.io/v2";

    @Test
    public void testPathParam(){

        Response response = given().accept(ContentType.JSON)
                .when().queryParam("id",25)
                .and().get(devexUrl + "/api/profile/userQuery");
        response.prettyPrint();
        assertTrue(response.asString().contains("jrdev@gmail.com"));
    }

    @Test
    public void testPathParams(){

        Response response = given().accept(ContentType.JSON)
                .when().queryParams("id",25,"name","Jr. Dev","email","jrdev@gmail.com")
                .and().get(devexUrl + "/api/profile/userQuery");

        response.prettyPrint();
    }

    @Test
    public void testPathParamswithMap(){

        Map<String,Object> queryParamsMap = new HashMap<>();

        queryParamsMap.put("id",25);
        queryParamsMap.put("name","Jr. Dev");
        queryParamsMap.put("email","jrdev@gmail.com");
        queryParamsMap.put("status","Junior Developer");
        queryParamsMap.put("company","google");
        queryParamsMap.put("profileId",1);

        Response response = given().accept(ContentType.JSON)
                .when().queryParams(queryParamsMap)
                .and().get(devexUrl + "/api/profile/userQuery");

        response.prettyPrint();
        assertTrue(response.headers().hasHeaderWithName("Date"));

    }




}
