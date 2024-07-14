package com.devex.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FürMapDataUserProfile {


    public static Map<String,Object> mapFürUser(){

        Map<String,Object> userMap= new HashMap<>();
        userMap.put("name","xyz");
        userMap.put("email","xyz1@gmail.com");
        userMap.put("password","xyz12345");
        userMap.put("google","xyzGoogle");
        userMap.put("facebook","xyzFacebook");
        userMap.put("github","xyzGithub");

        return userMap;
    }

    public static Map<String,Object> mapFürProfile(){

        Map<String,Object> userMap= new HashMap<>();
        Map<String,Object> profileMap= new HashMap<>();
        List<String> skills = new ArrayList<>();

        skills.add("Java");
        skills.add("Selenium");
        skills.add("SQL");

        profileMap.put("user",userMap);
        profileMap.put("company","amazon");
        profileMap.put("website","amazon.com");
        profileMap.put("youtube","xyzYoutube");
        profileMap.put("twitter","xyzTwitter");
        profileMap.put("facebook","xyzFacebook");
        profileMap.put("instagram","xyzInstagram");
        profileMap.put("linkedin","xyzLinkedin");
        profileMap.put("githubusername","xyzGithub");
        profileMap.put("status","status");
        profileMap.put("location","Frankfurt");
        profileMap.put("skills",skills);

        return profileMap;
    }
}
