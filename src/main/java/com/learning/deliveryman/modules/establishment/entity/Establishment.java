package com.learning.deliveryman.modules.establishment.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "establishments")
public class Establishment implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Integer document;
    private Integer mobile;
    private String address;
    private Boolean isActive = false;
    private Integer zipCode;

    public Establishment() {
    }

    public Establishment(String name, String email, String password, Integer document, Integer mobile, String address, Boolean isActive, Integer zipCode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.document = document;
        this.mobile = mobile;
        this.address = address;
        this.isActive = isActive;
        this.zipCode = zipCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

}
