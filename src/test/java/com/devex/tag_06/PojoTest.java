package com.devex.tag_06;

import com.devex.pojos.AllUsers;
import com.devex.pojos.TestUserQuery;
import com.devex.pojos.UserQuery;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PojoTest {
    Gson gson;
    @BeforeMethod
    public void setUp(){
        baseURI = "http://www.eurotech.study";
        gson=new Gson();
    }

    @Test
    public void test1() {

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

    @Test
    public void test2() {

        Response response = given().accept(ContentType.JSON)
                .when().pathParam("id", 2006)
                .and().get("/api/profile/user/{id}");

        AllUsers allUsers = response.body().as(AllUsers.class);
        //AllUsers allUsers = gson.fromJson(response.body().asString(), AllUsers.class);
        System.out.println("allUsers.getCompany() = " + allUsers.getCompany());

        System.out.println("allUsers.getUser().getEmail() = " + allUsers.getUser().getEmail());

        System.out.println("allUsers.getEducation().get(1).getSchool() = " + allUsers.getEducation().get(1).getSchool());

        System.out.println("allUsers.getExperience().get(0).getLocation() = " + allUsers.getExperience().get(0).getLocation());
    }


    @Test
    public void test3() {

        UserQuery userQuery = new UserQuery(1111111.0, "test@test.com", "testName", "testCompany", "available", 2222);

        String json = gson.toJson(userQuery);

        System.out.println("json = " + json);

    }

    @Test
    public void test4() {

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/profile");

        AllUsers[] usersArray = gson.fromJson(response.body().asString(), AllUsers[].class);

        System.out.println("usersArray[924].getGithubusername() = " + usersArray[924].getGithubusername());


    }

}
