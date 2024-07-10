package com.devex.tag_05;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/profile");

        response.then().assertThat().statusCode(200);

        System.out.println("response.headers() = " + response.headers());
    }

    @Test
    public void test2() {

        Response response = given().accept(ContentType.JSON)
                            .when().queryParam("id", "25")
                            .get("/api/profile/userQuery");
        response.prettyPrint();
    }

    @Test
    public void test3() {
        // url, request body + expected data + response'u kaydet
        Response response = given().accept(ContentType.JSON)
                .when().queryParam("id", "25")
                .get("/api/profile/userQuery");

        // assert
        response.then().assertThat().statusCode(200).and().contentType("application/json; charset=utf-8")
                .and().body("id", equalTo(25))
                .body("email", equalTo("jrdev@gmail.com"))
                .body("name", equalTo("Jr. Dev"))
                .body("status", is("Junior Developer"))
                .body("profileId", is(1));

    }

    @Test
    public void testName() {
        // url, request body + expected data + response'u kaydet
        Response response = given().accept(ContentType.JSON)
                .when().queryParam("id", "2006").log().all() // log().all() für wichtige request informationen
                .get("/api/profile/userQuery");

        System.out.println("********");

        // assert
        response.then().statusCode(200).contentType("application/json; charset=utf-8")
                .and()
                .header("ETag",Matchers.equalTo("W/\"80-fhUysXhC1S9dWXuDiV09Sgdn+68\""))
                .header("Date",Matchers.notNullValue())
                .body("profileId",equalTo(1119))
                .log().all(); // log().all() für wichtige response informationen
                // log().headers(); nur response header informationen
                // log().cookies(); nur response cookies
                // log().body(); nur response body

    }

    @Test
    public void test5() {
        // url, request body + expected data + response'u kaydet
        Response response = given().accept(ContentType.JSON).log().all() // log().all() für wichtige request informationen
                .when().get("/api/profile");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        // assert
        response.then().assertThat()
                .body("website", hasItem("amazon.com"))
                .body("location", hasItem("Frankfurt"))
                .body("githubusername", hasItem("eurotech_35"))
                .log().headers();
    }

    @Test
    public void test6() {
        // url, request body + expected data + response'u kaydet
        Response response = given().accept(ContentType.JSON).log().all() // log().all() für wichtige request informationen
                .when().get("/api/profile");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        // assert
        List<String> websites = new ArrayList<>();
        websites.add("google.com");
        websites.add("apple.com");
        websites.add("amazon.com");

        String [] websitesArray = {"amazon.com","google.com","apple.com"};

        response.then().assertThat()
                //.body("website", hasItems("amazon.com","google.com","apple.com"))
                //.body("website",hasItems(websites.toArray()))
                .body("website",hasItems(websitesArray))
                .log().headers();
    }

    @Test
    public void test7() {
        // url, request body + expected data + response'u kaydet
        Response response = given().accept(ContentType.JSON).log().all() // log().all() für wichtige request informationen
                .when().get("/api/profile");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        // assert
        response.then().assertThat()
                .body("user.email",hasItems("testaccount@gmail.com","talisca@gmail.com","euroTechStudy@gmail.com"))
                .body("user.name",hasItems("Study","Blg","Sar"))
                .log().headers();



    }
}
