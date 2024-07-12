package com.devex.tag_07;

import com.devex.pojos.PostUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostUserTest {

    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void test() { // body olusturuyoruz

        String userBody = """
                {
                "email": "sevgi1234@gmail.com",
                "password": "Test123",
                "name": "sevgi",
                "google": "string",
                "facebook": "string",
                "github": "string"
                }
                """;


        String name = "sevgi";
        Response response = given().accept(ContentType.JSON)
                            .and().contentType(ContentType.JSON)
                             .and().body(userBody) // serialization
                            .when().post("/api/users");

        response.then().assertThat().statusCode(200);
        Assert.assertTrue(response.body().asString().contains("token"));

        String token = response.path("token");
        System.out.println("token = " + token);

        Response response1 = given().accept(ContentType.JSON)
                             .and().header("x-auth-token", token)
                                .when().get("/api/auth");



        assertThat(response1.path("name"),equalTo(name));


    }

    @Test
    public void testWithMap() {

        Map<String, Object> userBodyMap = new HashMap<>();
        userBodyMap.put("email", "sevgi4@gmail.com");
        userBodyMap.put("password", "Test123");
        userBodyMap.put("name", "sevgi");
        userBodyMap.put("google", "string");
        userBodyMap.put("facebook", "string");
        userBodyMap.put("github", "string");


        String name = "sevgi";
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(userBodyMap) // serialization
                .when().post("/api/users");

        response.then().assertThat().statusCode(200);
        Assert.assertTrue(response.body().asString().contains("token"));

        String token = response.path("token");
        System.out.println("token = " + token);

        Response response1 = given().accept(ContentType.JSON)
                .and().header("x-auth-token", token)
                .when().get("/api/auth");



        assertThat(response1.path("name"),equalTo(name));

    }

    @Test
    public void PostUserWithPojo() {

        Map<String, Object> userBodyMap = new HashMap<>();
        userBodyMap.put("email", "sevgi5@gmail.com");
        userBodyMap.put("password", "Test123");
        userBodyMap.put("name", "sevgi");
        userBodyMap.put("google", "string");
        userBodyMap.put("facebook", "string");
        userBodyMap.put("github", "string");

        PostUser postUser = new PostUser();
        postUser.setEmail("sevgi6@gmail.com");
        postUser.setPassword("Test123");
        postUser.setName("Forrest Gump");
        postUser.setGoogle("string");
        postUser.setFacebook("string");
        postUser.setGithub("string");



        String name = "sevgi";
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(userBodyMap) // serialization
                .when().post("/api/users");

        response.then().assertThat().statusCode(200);
        Assert.assertTrue(response.body().asString().contains("token"));

        String token = response.path("token");
        System.out.println("token = " + token);

        Response response1 = given().accept(ContentType.JSON)
                .and().header("x-auth-token", token)
                .when().get("/api/auth");



        assertThat(response1.path("name"),equalTo(name));

    }
}
