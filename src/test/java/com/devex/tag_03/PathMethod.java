package com.devex.tag_03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static io.restassured.RestAssured.given;

public class PathMethod {

    String devexUrl = "http://www.eurotech.study";
    String psUrl = "http://petstore.swagger.io/v2";


    @Test
    public void testPathMethod(){

        Response response = given().accept(ContentType.JSON).when().pathParam("id",36)
                .and().get(devexUrl + "/api/profile/user/{id}");

        response.prettyPrint();


        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"company\") = " + response.path("company"));
        System.out.println("response.path(\"website\") = " + response.path("website"));
        System.out.println("response.path(\"skills\") = " + response.path("skills")); // [Java, Selenium, TestNG, Cucumber, API] List
        System.out.println("response.path(\"skills[0]\") = " + response.path("skills[0]")); // indeks nummer ile
        System.out.println("response.path(\"user.name\") = " + response.path("user.name")); //Anderson Talisca
        System.out.println("response.path(\"user.id\") = " + response.path("user.id")); // 36
        System.out.println("response.path(\"user.email\") = " + response.path("user.email"));
        System.out.println("response.path(\"experience\") = " + response.path("experience"));

        assertEquals((Integer) response.path("id"),5);
        assertEquals((Integer) response.path("user.id"),36);
        assertEquals(response.path("company"),"Al-Hilal");
        assertEquals(response.path("skills[0]"),"Java");

    }
}
