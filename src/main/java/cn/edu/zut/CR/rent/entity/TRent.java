package cn.edu.zut.CR.rent.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class TRent {
    private Integer id;
    private String rentSn;
    //    private Date rentDate;
    private Integer backDate;
    private BigDecimal rentPrice;
    private String status;
    private String operName;
    private Date createTime;
    private Date updateTime;
}