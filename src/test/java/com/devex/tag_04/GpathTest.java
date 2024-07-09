package com.devex.tag_04;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GpathTest {

    String baseUrl = "http://www.eurotech.study";
    @Test
    public void test1(){
        JsonPath jsonData = given().accept(ContentType.JSON)
                .when().queryParam("id", 34)
                .and().get(baseUrl + "/api/profile").jsonPath();

        // id'si 100'den kucuk olanlarin statusu
        for (Object status : jsonData.getList("findAll{it.id<100}.status")) {
            System.out.println("status = " + status);
        }

        // id'si 19 olanin user.name?
        String username19 = jsonData.getString("find{it.id==19}.user.name");
        System.out.println("username19 = " + username19);


        //  status'u Junior Dev olanlarin user.email'ini bulunuz
        for (Object jDevs : jsonData.getList("findAll{it.status=='Junior Developer'}.user.email")) {
            System.out.println("jDevs = " + jDevs);
        }

        // tum id'lerin toplami
        int sumOfIds = jsonData.getInt("id.sum()");
        System.out.println("sumOfIds = " + sumOfIds);

        // min Id
        System.out.println("jsonData.getInt(\"id.min()\") = " + jsonData.getInt("id.min()")); // id.min() = 1

        // max Id
        System.out.println("jsonData.getInt(\"id.max()\") = " + jsonData.getInt("id.max()")); // id.max() = 1165

        // kac id var?
        System.out.println("jsonData.getInt(\"id.size()\") = " + jsonData.getInt("id.size()"));

        // githubusername'si null olmayanlarin user.email'lerini getir
        List<Object> githubMails = jsonData.getList("findAll{it.githubusername!=null}.user.email");
        System.out.println("githubMails = " + githubMails);

        // experience'si null olmayanlarin user.email'lerini getir
        List<Object> experienceUsers = jsonData.getList("findAll{it.experience!=null}.user.email");
        System.out.println("experienceUsers = " + experienceUsers);


    }
}
