package com.techtwon.doitmission_13_2;

public class Person {
    String name;
    String birth;
    String mobile;
    int resId;


    public Person(String name, String birth, String mobile) {
        this.name = name;
        this.birth = birth;
        this.mobile = mobile;
    }

    public Person(String name, String birth, String mobile, int resId) {
        this.name = name;
        this.birth = birth;
        this.mobile = mobile;
        this.resId = resId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }


}
