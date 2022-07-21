package com.learning.deliveryman.modules.establishment.dtos;

public class ResponseEstablishmentDto {
    private String id;
    private String name;
    private String email;
    private Integer document;
    private Integer mobile;
    private String address;
    private Integer zipCode;

    public ResponseEstablishmentDto() {
    }

    public ResponseEstablishmentDto(String id, String name, String email, Integer document, Integer mobile, String address, Integer zipCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
        this.mobile = mobile;
        this.address = address;
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

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
