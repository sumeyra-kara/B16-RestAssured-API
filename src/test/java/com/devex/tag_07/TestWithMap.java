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
        Map<String, Object> userMap = FürMapDataUserProfile.mapFürUser();


        Response userResponse1 = given().contentType(ContentType.JSON)
                                .when().body(userMap)
                                .post("/api/users");

        Map<String, Object> profilMap = FürMapDataUserProfile.mapFürProfile();

        Response userResponse2 = given().contentType(ContentType.JSON)
                                .when().body(profilMap)
                                .post("/api/profile");

        userResponse2.prettyPrint();

        // Für assert

        Map<String,Object> responseMap = userResponse2.as(Map.class); // response'u map'e cevirdim


    }
}
