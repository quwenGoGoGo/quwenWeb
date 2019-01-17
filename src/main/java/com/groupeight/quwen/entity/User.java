package com.groupeight.quwen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    private String nikeName;

    private int gender;

    private String city;

    private String avatarUrl;

    private String openid;

    private int firstLogin;
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Collect> collects;
//
//    public List<Collect> getCollects() {
//        return collects;
//    }

//    public void setCollects(List<Collect> collects) {
//        this.collects = collects;
//    }
    public String getOpenid(){
        return openid;
    }
    public void setOpenid(String openid){
        this.openid = openid;
    }
    public int getFirstLogin(){
        return firstLogin;
    }
    public void setFirstLogin(int firstLogin){
        this.firstLogin = firstLogin;
    }
    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getName() {
        return nikeName;
    }

    public void setName(String nikeName) {
        this.nikeName = nikeName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "nikeName='" + nikeName + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", openid='" + openid + '\'' +
                ", firstLogin=" + firstLogin +
                '}';
    }
}
