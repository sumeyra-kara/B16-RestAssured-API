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
        for (Object status : jsonData.getList("findAll{it.id<100}.status")) {
            System.out.println("status = " + status);
        }

        String username19 = jsonData.getString("find{it.id==19}.user.name");
        System.out.println("username19 = " + username19);


        //  status'u Junior Dev olanlarin user.email'ini bulunuz
        for (Object jDevs : jsonData.getList("findAll{it.status=='Junior Developer'}.user.email")) {
            System.out.println("jDevs = " + jDevs);
        }


    }
}
