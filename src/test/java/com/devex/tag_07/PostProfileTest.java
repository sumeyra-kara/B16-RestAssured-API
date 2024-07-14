package com.devex.tag_07;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class PostProfileTest {
    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void test1() {

        String userBody = """
                {
                "email": "sevgi94@gmail.com",
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

        String token = response.path("token");
        System.out.println("token = " + token);


        response.then().assertThat().statusCode(200);
        Assert.assertTrue(response.body().asString().contains("token"));

        String profileBody = """
                {
                  "company": "Bubba Gump",
                  "website": "bubba.com",
                  "location": "USA",
                  "status": "available",
                  "skills": "HTML,CSS,Javascript",
                  "githubusername": "sevgigithub",
                  "youtube": "string",
                  "twitter": "string",
                  "facebook": "string",
                  "linkedin": "string",
                  "instagram": "string"
                }""";

        String website = "bubba.com";

        Response response2 = given().accept(ContentType.JSON)
                            .and().contentType(ContentType.JSON)
                             .and().header("x-auth-token",token)
                            .and().body(profileBody) // serialization
                            .when().post("/api/profile");

        response2.then().assertThat().statusCode(200).log().all();


        Response response3 = given().accept(ContentType.JSON)
                .and().header("x-auth-token", token)
                .and().get("/api/profile/me");


        assertEquals(response2.path("website"),website);
        System.out.println("*******************+");


        System.out.println("***************************+");

        response3.prettyPrint();

        // benutzen Sie Map und Pojo für den gleichen Test


    }
}
