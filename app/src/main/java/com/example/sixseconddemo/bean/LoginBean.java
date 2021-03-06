package com.example.sixseconddemo.bean;

public class LoginBean {


    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":"3b52c4551ee00f72","appsecret":"79A735B2A8B3E702BC1ED6BB7213B433","createtime":"2017-11-09T19:49:33","email":null,"gender":null,"icon":null,"mobile":"13278907890","money":null,"nickname":null,"password":"94E3FA7E637B0803B4034D7B1B165B83","token":"F5ED601F6C9D649E494A570AF6E72159","uid":1992,"username":"13278907890"}
     * 用户名：17744537076
     * 密码：960602
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : 3b52c4551ee00f72
         * appsecret : 79A735B2A8B3E702BC1ED6BB7213B433
         * createtime : 2017-11-09T19:49:33
         * email : null
         * gender : null
         * icon : null
         * mobile : 13278907890
         * money : null
         * nickname : null
         * password : 94E3FA7E637B0803B4034D7B1B165B83
         * token : F5ED601F6C9D649E494A570AF6E72159
         * uid : 1992
         * username : 13278907890
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object gender;
        private Object icon;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private String token;
        private int uid;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
