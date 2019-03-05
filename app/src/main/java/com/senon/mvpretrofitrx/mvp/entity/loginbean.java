package com.senon.mvpretrofitrx.mvp.entity;

public class loginbean {
    /**
     * msg : 请求成功
     * code : 1
     * info : {"deviceType":"android","teamName":"六战区","ylssRoleId":0,"roleId":2,"headImage":"http://192.168.1.166/scssimg/pictures/8/8/dda2cbb1-bfaf-440f-be85-e61b391dd224_20171218222223.jpg","groupId":3,"ylssTeamName":"","label":1,"userName":"scss33033","userId":2033,"phoneNo":"","userInfoId":0,"deviceToken":"Apglim60w-sc6nOR5aOQ9k98nbv2HL4HSWxuPsO3t4YP","realName":"安营","groupName":"第三集团军","ylssTeamId":0,"teamId":6,"grade":3,"departId":0,"jobType":0,"departName":""}
     */

    private String msg;
    private int code;
    /**
     * deviceType : android
     * teamName : 六战区
     * ylssRoleId : 0
     * roleId : 2
     * headImage : http://192.168.1.166/scssimg/pictures/8/8/dda2cbb1-bfaf-440f-be85-e61b391dd224_20171218222223.jpg
     * groupId : 3
     * ylssTeamName :
     * label : 1
     * userName : scss33033
     * userId : 2033
     * phoneNo :
     * userInfoId : 0
     * deviceToken : Apglim60w-sc6nOR5aOQ9k98nbv2HL4HSWxuPsO3t4YP
     * realName : 安营
     * groupName : 第三集团军
     * ylssTeamId : 0
     * teamId : 6
     * grade : 3
     * departId : 0
     * jobType : 0
     * departName :
     */

    private InfoEntity info;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public InfoEntity getInfo() {
        return info;
    }

    public static class InfoEntity {
        private String deviceType;
        private String teamName;
        private int ylssRoleId;
        private int roleId;
        private String headImage;
        private int groupId;
        private String ylssTeamName;
        private int label;
        private String userName;
        private int userId;
        private String phoneNo;
        private int userInfoId;
        private String deviceToken;
        private String realName;
        private String groupName;
        private int ylssTeamId;
        private int teamId;
        private int grade;
        private int departId;
        private int jobType;
        private String departName;

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public void setYlssRoleId(int ylssRoleId) {
            this.ylssRoleId = ylssRoleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public void setHeadImage(String headImage) {
            this.headImage = headImage;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public void setYlssTeamName(String ylssTeamName) {
            this.ylssTeamName = ylssTeamName;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public void setUserInfoId(int userInfoId) {
            this.userInfoId = userInfoId;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public void setYlssTeamId(int ylssTeamId) {
            this.ylssTeamId = ylssTeamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public void setDepartId(int departId) {
            this.departId = departId;
        }

        public void setJobType(int jobType) {
            this.jobType = jobType;
        }

        public void setDepartName(String departName) {
            this.departName = departName;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public String getTeamName() {
            return teamName;
        }

        public int getYlssRoleId() {
            return ylssRoleId;
        }

        public int getRoleId() {
            return roleId;
        }

        public String getHeadImage() {
            return headImage;
        }

        public int getGroupId() {
            return groupId;
        }

        public String getYlssTeamName() {
            return ylssTeamName;
        }

        public int getLabel() {
            return label;
        }

        public String getUserName() {
            return userName;
        }

        public int getUserId() {
            return userId;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public int getUserInfoId() {
            return userInfoId;
        }

        public String getDeviceToken() {
            return deviceToken;
        }

        public String getRealName() {
            return realName;
        }

        public String getGroupName() {
            return groupName;
        }

        public int getYlssTeamId() {
            return ylssTeamId;
        }

        public int getTeamId() {
            return teamId;
        }

        public int getGrade() {
            return grade;
        }

        public int getDepartId() {
            return departId;
        }

        public int getJobType() {
            return jobType;
        }

        public String getDepartName() {
            return departName;
        }
    }

}
