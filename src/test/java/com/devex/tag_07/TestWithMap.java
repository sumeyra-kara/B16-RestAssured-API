package com.devex.tag_07;

import com.devex.pojos.FürMapDataUserProfile;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
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
    public static void testwithMap() {
        Map<String, String> userMap = FürMapDataUserProfile.mapFürUser();

        Response userResponse1 = given().contentType(ContentType.JSON)
                                .when().body(userMap)
                                .post("/api/users").then().log().all().extract().response();

        String token = userResponse1.path("token");
        System.out.println("token = " + token);


        Map<String, Object> profilMap = FürMapDataUserProfile.mapFürProfile();

        Response userResponse2 = given()
                                .and().contentType(ContentType.JSON)
                                .and().header("x-auth-token",token)
                                .body(profilMap)
                                .post("/api/profile").then().log().all().extract().response();


        Response userResponse3 = given().accept(ContentType.JSON)
                                .and().header("x-auth-token",token)
                                .and().get("/api/profile/me").then().log().all().extract().response(); // profile inormationen
        // Für assert

        Map<String,Object> responseMap = userResponse3.as(Map.class); // response'u map'e cevirdim

        Assert.assertEquals(((Map)responseMap.get("user")),"id");





    }
}
