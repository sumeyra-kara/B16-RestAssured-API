package com.devex.tag_06;

import com.devex.pojos.TestUserQuery;
import com.devex.pojos.UserQuery;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PojoTest {
    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
    }

    @Test
    public void test() {

        Response response = given().accept(ContentType.JSON).when().queryParam("id", 2006)
                .get("/api/profile/userquery");
        response.prettyPrint();


        // response to map
        Map<String,Object> user = response.as(Map.class);

        UserQuery pojoUser = response.as(UserQuery.class); // de-serialization with pojo class
        System.out.println("pojoUser.getCompany() = " + pojoUser.getCompany()); // EuroTech Study
        System.out.println("pojoUser.getId() = " + pojoUser.getId()); // 2006.0
        System.out.println("pojoUser.getName() = " + pojoUser.getName()); // batch16
        System.out.println("pojoUser.getProfileId() = " + pojoUser.getProfileId());
        System.out.println("pojoUser.getEmail() = " + pojoUser.getEmail());
        System.out.println("pojoUser.getStatus() = " + pojoUser.getStatus());

        TestUserQuery testUserQuery = response.as(TestUserQuery.class);
        System.out.println("testUserQuery.getCompany() = " + testUserQuery.getCompany());


    }
}
