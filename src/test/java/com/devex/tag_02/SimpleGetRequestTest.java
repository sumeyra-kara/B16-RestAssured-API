package com.devex.tag_02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetRequestTest {

    String url= "http://www.eurotech.study";

    @Test
    public void testSimpleGetRequest(){
        // given : Testimize baslarken bize verilen baslangic degerlerini ifade eder
        // when : Testimizde gerceklestirdigimiz islemleri ifade eder
        // then : Response degerlerini degerlendirmek icin yapilan islemleri ifade eder
        // and : Birbirine bagli islemleri ifade eder

        Response response = RestAssured.given().get(url + "/api/profile"); // response classìndan obje olusturulur sorgu yapmak icin

        System.out.println("response.statusCode() = " + response.statusCode()); // 200
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.time() = " + response.time()); // Time
        System.out.println("response.prettyPrint() = " + response.prettyPrint()); // pretty
        System.out.println("response.getStatusCode() = " + response.getStatusCode()); // 200
    }


    @Test
    public void testSimpleGetRequest2(){
        Response response =RestAssured.given().accept(ContentType.JSON).when().get(url + "/api/profile");
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void testSimpleGetRequest3(){
        Response response =RestAssured.given().accept(ContentType.JSON).when().get(url + "/api/profile");
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
    }

    @Test
    public void testSimpleGetRequest4(){
        Response response =RestAssured.given().accept(ContentType.JSON).when().get(url + "/api/profile");

        // verifizierung
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8");
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        Assert.assertTrue(response.asString().contains("jrdev@gmail.com"));





    }


}
