package com.devex.pojos;

public class UserFürPojo {

    private String name;
    private String email;
    private String password;
    private Object google;
    private Object github;
    private Object facebook;

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

    public UserFürPojo(String name, String email, String password, Object google, Object github, Object facebook) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.google = google;
        this.github = github;
        this.facebook = facebook;
    }

    public UserFürPojo() {
    }

    @Override
    public String toString() {
        return "UserFürPojo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", google=" + google +
                ", github=" + github +
                ", facebook=" + facebook +
                '}';
    }


}
