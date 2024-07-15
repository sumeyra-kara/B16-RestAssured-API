package com.devex.tag_08;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class PutAndPatch {

    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void putRequestTest() {
        String token = Authorization.getToken();

        Map<String,Object> putBodyMap = new HashMap<>();
        putBodyMap.put("title", "Senior SDET");
        putBodyMap.put("company", "Google");
        putBodyMap.put("location", "New York");
        putBodyMap.put("from", "2019-02-02");
        putBodyMap.put("to", "-");
        putBodyMap.put("current", true);
        putBodyMap.put("description", "works as professional Senior SDET");


        Response putResponse = given().pathParam("id", 2017)
                .and().contentType(ContentType.JSON)
                .and().header("x-auth-token", token)
                .body(putBodyMap).when().put("/api/profile/experience/{id}");

        putResponse.then().assertThat().statusCode(204);


        JsonPath jsonPath = given().accept(ContentType.JSON).pathParam("id", 2017)
                .and().header("x-auth-token", token)
                .when()
                .get("/api/profile/experience/{id}").jsonPath();

        Assert.assertEquals(jsonPath.getString("title"),"Senior SDET");


    }

    @Test
    public void test() {

        String token = Authorization.getToken();

        Map<String,Object> patchBodyMap = new HashMap<>();
        patchBodyMap.put("current", false);
        patchBodyMap.put("from", "2024-01-01");

        Response patchResponse = given().pathParam("id", 2017)
                                .and().contentType(ContentType.JSON)
                                .and().header("x-auth-token", token)
                                .body(patchBodyMap).when().patch("/api/profile/experience/{id}");

        patchResponse.then().assertThat().statusCode(204);

        // get
        JsonPath jsonPath = given().accept(ContentType.JSON).pathParam("id", 2017)
                            .and().header("x-auth-token", token)
                            .when()
                            .get("/api/profile/experience/{id}").jsonPath();
        jsonPath.prettyPrint();

        Assert.assertEquals(jsonPath.getBoolean("current"),false);

    }
}
