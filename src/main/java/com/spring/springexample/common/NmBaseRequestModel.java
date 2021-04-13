package com.spring.springexample.common;

public class NmBaseRequestModel {
    Long userId;
    String deviceName;
    String language;
    String platform;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        language = language;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Boolean validate(){
        if(userId!= null && userId>0 && language!=null && deviceName!=null && platform!=null){
            return  true;
        }
        return false;
    }
}
