package com.devex.tag_03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class PetParamTest {
    // endpoint'in bir parcasidir

    String devexUrl = "http://www.eurotech.study";
    String psUrl = "http://petstore.swagger.io/v2";

    @Test
    public void testPathParam(){

        Response response = given().accept(ContentType.JSON).when().get(devexUrl + "/api/profile/user/25");
        response.prettyPrint();

    }
    @Test
    public void testPathParam2(){

        Response response = given().accept(ContentType.JSON).when().pathParam("id",25).and().get(devexUrl + "/api/profile/user/{id}");
        response.prettyPrint();
        assertTrue(response.asString().contains("jrdev@gmail.com"));

    }


}
