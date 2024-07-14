package com.devex.tag_07;

import com.devex.pojos.FürMapDataUserProfile;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestWithMap {

    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void testwithMap() {


        Response userResponse = given().contentType(ContentType.JSON).when().body(FürMapDataUserProfile.mapFürUser().toString()).post("/api/profile");
        System.out.println("userResponse.statusCode() = " + userResponse.statusCode());

    }
}
