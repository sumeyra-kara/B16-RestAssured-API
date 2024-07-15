package com.devex.tag_07;

import com.devex.pojos.ProfilFürPojo;
import com.devex.pojos.User;
import com.devex.pojos.UserFürPojo;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TestWithPojo {

    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public static String getToken() {

        UserFürPojo user = new UserFürPojo("sevgi","sevgi1423@gmail.com","sevgi12345","sevgiGoogle","sevgiGithub","sevgiFacebook");


        Response response = given().contentType(ContentType.JSON).when().body(user).post("/api/users");

        String token = response.path("token");
        
        return token;

    }


    @Test
    public void testProfile() {

        UserFürPojo user = new UserFürPojo("sevgi","sevgi14001@gmail.com","sevgi12345","sevgiGoogle","sevgiGithub","sevgifacebook");

        Response response1 = given().contentType(ContentType.JSON)
                            .when().body(user).post("/api/users")
                            .then().log().all().extract().response();
        // String token = response1.path("token");
        String token= TestWithPojo.getToken();


        ProfilFürPojo profilForUser = new ProfilFürPojo("amazon","amazon.com","youtube.com","twitter.com","instagram.com","linkedinSevgi","sevgifacebook","Frankfurt","QA","Java,Selenium,CSS","sevgiGithub");

        Response response =  given()
                             .and().contentType(ContentType.JSON)
                             .and().header("x-auth-token",token)
                             .body(profilForUser).post("/api/profile")
                             .then().log().all().extract().response();


        Response response2 = given().accept(ContentType.JSON)
                            .and().header("x-auth-token", token)
                            .when().get("/api/profile/me")
                             .then().log().all().extract().response();



        System.out.println("***************** Assert Beginn ***********");

        System.out.println("response2.path(\"company\") = " + response2.path("company"));


    }
}
