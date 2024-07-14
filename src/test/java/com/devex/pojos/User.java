
package com.devex.pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User { // map

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String avatar;
    private String date;
    private Object google;
    private Object github;
    private Object facebook;
    private Integer profileId;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getGoogle() {
        return google;
    }

    public void setGoogle(Object google) {
        this.google = google;
    }

    public Object getGithub() {
        return github;
    }

    public void setGithub(Object github) {
        this.github = github;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    //  toString metodu olusturalim
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", date='" + date + '\'' +
                ", google=" + google +
                ", github=" + github +
                ", facebook=" + facebook +
                ", profileId=" + profileId +
                '}';
    }


    // tum parametreleri kullanarak bir constructor olusturalim
    public User(Integer id, String name, String email, String password, String avatar, String date, Object google, Object github, Object facebook, Integer profileId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.date = date;
        this.google = google;
        this.github = github;
        this.facebook = facebook;
        this.profileId = profileId;
    }
}
