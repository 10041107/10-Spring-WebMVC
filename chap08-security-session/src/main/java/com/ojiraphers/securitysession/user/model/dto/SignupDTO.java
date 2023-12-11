package com.ojiraphers.securitysession.user.model.dto;

public class SignupDTO {

    private String userID;
    private String userName;
    private String userPass;
    private String role;


    public SignupDTO() {
    }

    public SignupDTO(String userID, String userName, String userPass, String role) {
        this.userID = userID;
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SignupDTO{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
