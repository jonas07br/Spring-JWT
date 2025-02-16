package com.spring_security_jwt.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("unused")
public class JWTObject {
    private String subject; //nome do usuario
    private Date issuedAt; //data de criação do token
    private Date expiration; // data de expiração do token
    private List<String> roles; //perfis de acesso
    
    public void setRoles(String... roles){
        this.roles = Arrays.asList(roles);
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Date getIssuedAt() {
        return issuedAt;
    }
    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }
    public Date getExpiration() {
        return expiration;
    }


    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }



    public List<String> getRoles() {
        return roles;
    }



    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
