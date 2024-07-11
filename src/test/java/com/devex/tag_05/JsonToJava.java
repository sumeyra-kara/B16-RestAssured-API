package com.devex.tag_05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class JsonToJava {
    // Verilen Json objesini testlerimizde kullanmak uzere Java objesine cevirmeye ise De-Serialization denir.
    // Bunun icin Gson kutuphanesinden yararlanabiliriz.
    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON).when().queryParam("id", 2006)
                .get("/api/profile/userquery");
        response.prettyPrint();

        Map<String,Object> map = response.as(Map.class); // De-Serialization ile Json iken Map'e cevriliyor
        System.out.println("map = " + map); // suan map formatinda

    }

    @Test
    public void test2() {

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/profile");
        // suan response json formatinda-- ama ....
        List<Map<String,Object>> list = response.as(List.class); // jsonObject list'e yani java object'i cevriliyor

        System.out.println("list = " + list);
    }
}
