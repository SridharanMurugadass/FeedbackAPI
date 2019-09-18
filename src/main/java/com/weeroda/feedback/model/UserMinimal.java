package com.weeroda.feedback.model;

public class UserMinimal {
    private String id;
    private String userName;
    private String mobile;
    private String firstname;
    private String lastname;
    private String email;

    public UserMinimal() {
    }

    public UserMinimal(User user) {
        id = user.get_id();
        userName = user.getUserId();
        mobile = user.getMobile();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
