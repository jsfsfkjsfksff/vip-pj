package cn.edu.zut.CR.customer.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Customer {
        private Integer id;
        private String identity;
        private String customerName;
        private String gender;
        private String address;
        private String phoneNumber;
        private Timestamp createTime;
        private Timestamp updateTime;
        private String createdBy;
        private String updatedBy;
}
