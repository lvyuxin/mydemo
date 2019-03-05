package com.senon.mvpretrofitrx.mvp.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id
    private Long id;
    @Property(nameInDb = "USERNAME")
    private String  userName;
    @Property(nameInDb = "PASSWORD")
    private String  password;
    private String  content;
    @Generated(hash = 883919294)
    public User(Long id, String userName, String password, String content) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.content = content;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
