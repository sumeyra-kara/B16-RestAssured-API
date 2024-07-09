package com.devex.tag_04;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JsonPathTest {
    String baseUrl = "http://www.eurotech.study";
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().queryParam("id", 34)
                .and().get(baseUrl + "/api/profile/userQuery");
        response.prettyPrint();

        JsonPath jsonData = response.jsonPath();
        String status = jsonData.get("status"); // return type string
        Object status1 = response.path("status"); // return type object

        System.out.println("status = " + status);
        System.out.println("status1 = " + status1);

        int profileId = jsonData.getInt("profileId");
        System.out.println("profileId = " + profileId);
    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().queryParam("id", 34)
                .and().get(baseUrl + "/api/profile");

        JsonPath jsonData = response.jsonPath();
        List<Integer> userIds = jsonData.getList("user.id");

        System.out.println("userIds.size() = " + userIds.size()); // 938
        System.out.println("userIds = " + userIds);
        // ************* MAP ++++++++ ilk user bilgileri

        Map<String, Object> firstUserInfo = jsonData.getMap("user[0]");
        // System.out.println("firstUserInfo.keySet() = " + firstUserInfo.keySet());

        for (String key : firstUserInfo.keySet()){
            System.out.println(key + " : " + firstUserInfo.get(key));
        }

        // peki tum user bilgileri icin list und Map

        List<Map<String,Object>> alleUserInfos  =jsonData.getList("user");

        for (Map<String,Object> allUserInfo : alleUserInfos){
            if (allUserInfo==null){ // bazi degerler null oldugundan exception firlatmasin diye yazildi
                continue;
            }
            for (String key :  allUserInfo.keySet()){
                System.out.println(key +" : " +allUserInfo.get(key));
            }
        }
        //
        System.out.println("*****************");

        List<String> skills = jsonData.getList("[1].skills"); // fur erste Users skills
        skills.forEach(p -> System.out.println("p = " + p));

        List<List<String>> usersForSkills = jsonData.getList("skills"); // alle users skills

        for (List<String> skillsList : usersForSkills) {
            for (String skill : skillsList) {
                System.out.println("skill = " + skill);
            }
        }


    }



}
