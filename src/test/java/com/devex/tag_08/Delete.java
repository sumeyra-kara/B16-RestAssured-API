package com.devex.tag_08;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Delete {
    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void deleteRequestTest() {
        String token = Authorization.getToken();

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .and().pathParam("id", 2017)
                .and().contentType(ContentType.JSON)
                .and().header("x-auth-token", token)
                .when().delete("/api/profile/experience/{id}").then().assertThat().extract().jsonPath();

        Assert.assertTrue(jsonPath.getList("experience").isEmpty());


    }
}
