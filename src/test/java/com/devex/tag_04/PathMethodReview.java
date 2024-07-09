package com.devex.tag_04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class PathMethodReview {
    String baseUrl = "http://www.eurotech.study";
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON).when().get(baseUrl + "/api/profile");

        List<Integer> id = response.path("id"); // list
        System.out.println("id = " + id);

        Integer path = response.path("id[0]"); // with index nur first element
        System.out.println("path = " + path);

        Integer firstId = response.path("[0].id");
        // System.out.println("firstId = " + firstId);

        System.out.println("response.path(\"status[-2]\") = " + response.path("status[-1]")); // sonuncu
        System.out.println("response.path(\"website[-2]\") = " + response.path("website[-2]")); // sondan ikinci

        System.out.println("response.path(\"skills[3][3]\") = " + response.path("skills[3][3]")); // 3. olanin 3.skill'i
        System.out.println("response.path(\"[3].skills[3]\") = " + response.path("[3].skills[3]")); // diger yol

        System.out.println("response.path(\"user[1].email\") = " + response.path("user[1].email"));
        System.out.println("response.path(\"[1].user.email\") = " + response.path("[1].user.email")); // diger yol
        System.out.println("response.path(\"user.email\") = " + response.path("user.email"));

        System.out.println("response.path(\"[5]\") = " + response.path("[5]")); // 5.indekse ait tum bilgiler gelir
        System.out.println("response.path(\"experience[5]\") = " + response.path("experience[5]"));

        System.out.println("response.path(\"experience[5].title\") = " + response.path("experience[5].title")); // tester
        System.out.println("response.path(\"experience.title[5]\") = " + response.path("experience.title[5]")); // tester
        System.out.println("response.path(\"[5].experience.title\") = " + response.path("[5].experience.title")); // tester

    }


}
