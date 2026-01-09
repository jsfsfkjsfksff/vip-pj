package cn.edu.zut.CR.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Rent {
    private Integer id;
    private String rentSn;
    private Integer carId;
    private String carNumber;
    private String brand;
    private Integer customerId;
    private String customerName;
//    private Date rentDate;
    private Integer backDate;
    private BigDecimal rentPrice;
    private String status;
    private String operName;
    private Date createTime;
    private Date updateTime;
}