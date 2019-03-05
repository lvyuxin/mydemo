package com.senon.mvpretrofitrx.mvp.entity;

import java.util.List;

/**
 * Created by Administrator on 2019/2/22.
 */

public class A_regsin {

    /**
     * errorCode : 0
     * data : {"chapterTops":[],"collectIds":[],"email":"","icon":"","id":17711,"password":"","token":"","type":0,"username":"444444123"}
     * errorMsg : 
     */

    private int errorCode;
    /**
     * chapterTops : []
     * collectIds : []
     * email : 
     * icon : 
     * id : 17711.0
     * password : 
     * token : 
     * type : 0.0
     * username : 444444123
     */

    private DataEntity data;
    private String errorMsg;

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public DataEntity getData() {
        return data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static class DataEntity {
        private String email;
        private String icon;
        private double id;
        private String password;
        private String token;
        private double type;
        private String username;
        private List<?> chapterTops;
        private List<?> collectIds;

        public void setEmail(String email) {
            this.email = email;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setId(double id) {
            this.id = id;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setType(double type) {
            this.type = type;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public void setCollectIds(List<?> collectIds) {
            this.collectIds = collectIds;
        }

        public String getEmail() {
            return email;
        }

        public String getIcon() {
            return icon;
        }

        public double getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }

        public String getToken() {
            return token;
        }

        public double getType() {
            return type;
        }

        public String getUsername() {
            return username;
        }

        public List<?> getChapterTops() {
            return chapterTops;
        }

        public List<?> getCollectIds() {
            return collectIds;
        }
    }
}
