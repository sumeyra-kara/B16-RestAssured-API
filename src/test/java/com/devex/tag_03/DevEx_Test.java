package com.devex.tag_03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class DevEx_Test {

    String url = "http://www.eurotech.study";

    @Test
    public void testDevEx(){
        Response response = get(url + "/api/profile");
        System.out.println("StatusCode = " + response.getStatusCode());
        assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testDevEx2(){
        Response response = given().accept(ContentType.JSON).when().get(url + "/api/profile");
        // sonuc kismindaki header'lerin degerlerini alabiliriz
        System.out.println("response.header(\"eTag\") = " + response.header("ETag"));
        System.out.println("response.header(\"Content-Type\") = " + response.header("Content-Type"));
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));
        System.out.println("response.header(\"Date\") = " + response.header("Date"));

        assertEquals(response.contentType(),"application/json; charset=utf-8");
        assertEquals(response.header("ETag"),"W/\"c13cc-Q/gbyg1iKn2vJ0kpzRTfTr/4R2w\"");
        System.out.println("response.headers().hasHeaderWithName(\"Date\") = " + response.headers().hasHeaderWithName("Date"));
        assertTrue(response.headers().hasHeaderWithName("Date"));
        assertTrue(response.headers().hasHeaderWithName("ETag"));
        assertTrue(response.headers().hasHeaderWithName("Content-Type"));

        System.out.println("LocalDate.now() = " + LocalDate.now());
        System.out.println("LocalDate.now() = " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH)));
        String actualDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH));
        assertTrue(response.header("Date").contains(actualDate));






    }






}
