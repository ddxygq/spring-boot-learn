package com.ikeguang.oath.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@ToString
// @Configuration
public class GitHubAccessModel {
    //@Value("${oauth.github.clientId}")
    private String clientId = "6f286cb0adc5c19659aa";

    //@Value("${oauth.github.clientSecret}")
    private String clientSecret = "0cb56d595b37d96e2dd7480c98b5d153a74c8088";

    private String code;

    //@Value("${oauth.github.redirectUri}")
    private String redirectUri = "http://localhost:8080/oauth/callback/github";

    private String state;

}
