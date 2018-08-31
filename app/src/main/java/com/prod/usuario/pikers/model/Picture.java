package com.prod.usuario.pikers.model;

public class Picture {

    private String picture;
    private String userName;
    private String time;
    private String like_number = "0";
    private boolean isLike = false;

    public Picture(String picture, String userName, String time, String like_number, boolean isLike) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.like_number = like_number;
        this.isLike = isLike;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike_number() {
        return like_number;
    }

    public void setLike_number(String like_number) {
        this.like_number = like_number;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

}
