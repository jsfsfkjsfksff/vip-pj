package cn.edu.zut.CR.user.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class User {
    private Integer id;
    private String userName;
    private String nickName;
    private String password;
    private String email;
    private String phoneNumber;
    private Timestamp createTime;
    private Timestamp updateTime;
}
