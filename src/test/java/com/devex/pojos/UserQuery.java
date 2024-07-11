package com.devex.pojos;

public class UserQuery {
    // 1- tum variable'lari private olarak olustur (encapsulation olsun diye privat yapiyoru)
    private Double id;
    private String email;
    private String name;
    private String company;
    private String status;
    private Integer profileId;

    // 2- tum variable'lar icin getter ve setter metodlari olusturalim --- sag tik - generate .getter setter
    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }
}
