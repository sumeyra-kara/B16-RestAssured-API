package com.devex.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FürMapDataUserProfile {


    public static Map<String,String> mapFürUser(){

        Map<String,String> userMap= new HashMap<>();
        userMap.put("name","xyz");
        userMap.put("email","xyz226@gmail.com");
        userMap.put("password","xyz12345");
        userMap.put("google","xyzGoogle");
        userMap.put("facebook","xyzFacebook");
        userMap.put("github","xyzGithub");

        return userMap;
    }

    public static Map<String,Object> mapFürProfile(){

        Map<String,Object> profileMap= new HashMap<>();

       // profileMap.put("user",mapFürUser());
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
        profileMap.put("skills","Java,Selenium,CSS");

        return profileMap;
    }
}
