package com.devex.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfilFürPojo {

    private String company;
    private String website;
    private String youtube;
    private String twitter;
    private String instagram;
    private String linkedin;
    private String facebook;
    private String location;
    private String status;
    private String skills;
    private String githubusername;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getGithubusername() {
        return githubusername;
    }

    public void setGithubusername(String githubusername) {
        this.githubusername = githubusername;
    }

    @Override
    public String toString() {
        return "ProfilFürPojo{" +
                "company='" + company + '\'' +
                ", website='" + website + '\'' +
                ", youtube='" + youtube + '\'' +
                ", twitter='" + twitter + '\'' +
                ", instagram='" + instagram + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", facebook='" + facebook + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", skills='" + skills + '\'' +
                ", githubusername='" + githubusername + '\'' +
                '}';
    }

    public ProfilFürPojo(String company, String website, String youtube, String twitter, String instagram, String linkedin, String facebook, String location, String status, String skills, String githubusername) {
        this.company = company;
        this.website = website;
        this.youtube = youtube;
        this.twitter = twitter;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.facebook = facebook;
        this.location = location;
        this.status = status;
        this.skills = skills;
        this.githubusername = githubusername;
    }

    public ProfilFürPojo() {
    }
}
