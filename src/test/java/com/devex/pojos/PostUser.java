package com.devex.pojos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostUser {

    private String email;
    private String password;
    private String name;
    private String google;
    private String facebook;
    private String github;


}
