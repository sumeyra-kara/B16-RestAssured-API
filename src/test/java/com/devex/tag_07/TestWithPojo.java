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

        UserFürPojo user = new UserFürPojo("sevgi","sevgi145@gmail.com","sevgi12345","sevgiGoogle","sevgiGithub","sevgiFacebook");
        System.out.println("user.getName() = " + user.getName());

        // Response olustur
        Response response = given().contentType(ContentType.JSON).when().body(user).post("/api/users");
        response.prettyPrint();

    }


    @Test
    public void testProfile() {
        UserFürPojo user = new UserFürPojo("sevgi","sevgi092@gmail.com","sevgi12345","sevgiGoogle","sevgiGithub","sevgifacebook");

        String token  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoyMjI0fSwiaWF0IjoxNzIwOTY4MzYwLCJleHAiOjE3MjEzMjgzNjB9.LK2HEJh-GrC48t6mcMhfmIGUOASIdsqyGUpuIwFUSqs";

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Selenium");
        skills.add("SQL");


        ProfilFürPojo profilForUser = new ProfilFürPojo("amazon","amazon.com","youtube.com","twitter.com","instagram.com","linkedinSevgi","sevgifacebook","Frankfurt","QA",skills,"sevgiGithub", user);
        Response response = given().contentType(ContentType.JSON).when().body(profilForUser).post("/api/profile");
        response.prettyPrint();

        Response response1 = given().header("x-auth-token", token).get("/api/profile/me");

        response1.prettyPrint();


        /*
        System.out.println("***************** Assert Beginn ***********");

        ProfilFürPojo profilFürPojo = response.as(ProfilFürPojo.class);
        System.out.println("profilFürPojo.getLocation() = " + profilFürPojo.getLocation());

         */



    }
}
