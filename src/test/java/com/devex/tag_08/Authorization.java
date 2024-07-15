package com.devex.tag_08;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class Authorization {

    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public static String getToken() {

        String body = """
                {
                  "email": "gollum28@gmail.com",
                  "password": "test123"
                }""";

        JsonPath jsonPath = given().accept(ContentType.JSON)
                            .and().contentType(ContentType.JSON)
                            .body(body).when().post("/api/auth").jsonPath();

        String token = jsonPath.getString("token");
        return token;
    }

    @Test
    public void addExperience() {
        String token = getToken();

        String postBody = """
                {
                  "title": " Senior Full Stack SDET",
                  "company": "Zalando",
                  "location": "Frankfurt",
                  "from": "2018-02-02",
                  "to": "2020-02-03",
                  "current": false,
                  "description": "worked as professional SDET"
                }""";

        Response postResponse = given().accept(ContentType.JSON)
                                .and().contentType(ContentType.JSON)
                                .and().header("x-auth-token", token)
                                .body(postBody)
                                .when()
                                .post("/api/profile/experience");

        postResponse.then().assertThat().statusCode(201);
    }


    @Test
    public void getAllExperiences() {
        String token = getToken();

        Response postResponse = given().accept(ContentType.JSON)
                                .and().header("x-auth-token", token)
                                .log().all() // für request informationen
                                .when()
                                .get("/api/profile/experience");

        postResponse.then().assertThat().statusCode(200)
                .log().all(); //  für response informationen

    }

    @Test
    public void getAllExperiencesWithId() {
        String token = getToken();

        Response postResponse = given().accept(ContentType.JSON).pathParam("id",2017)
                .and().header("x-auth-token", token)
                .log().all() // für request informationen
                .when()
                .get("/api/profile/experience/{id}");

        postResponse.then().assertThat().statusCode(200)
                                .log().all(); //  für response informationen

    }



}
