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
    public void testUserWithPojo() {

        UserFürPojo user = new UserFürPojo("sevgi","sevgi148@gmail.com","sevgi12345","sevgiGoogle","sevgiGithub","sevgiFacebook");
        System.out.println("user.getName() = " + user.getName());

        // Response olustur
        Response response = given().contentType(ContentType.JSON).when().body(user).post("/api/users");

        String token = response.path("token");
        response.prettyPrint();

    }


    @Test
    public void testProfile() {

        UserFürPojo user = new UserFürPojo("sevgi","sevgi148@gmail.com","sevgi12345","sevgiGoogle","sevgiGithub","sevgifacebook");

        Response response1 = given().contentType(ContentType.JSON).when().body(user).post("/api/users");
        String token = response1.path("token");


        ProfilFürPojo profilForUser = new ProfilFürPojo("amazon","amazon.com","youtube.com","twitter.com","instagram.com","linkedinSevgi","sevgifacebook","Frankfurt","QA","Java,Selenium,CSS","sevgiGithub");

        Response response = given().contentType(ContentType.JSON).when().header("x-auth-token",token)
                            .body(profilForUser).post("/api/profile");
        response.prettyPrint();

        Response response2 = given().header("x-auth-token", token).when().get("/api/profile/me");


        /*
        System.out.println("***************** Assert Beginn ***********");

        ProfilFürPojo profilFürPojo = response.as(ProfilFürPojo.class);


         */



    }
}
