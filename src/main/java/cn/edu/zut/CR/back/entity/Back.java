package cn.edu.zut.CR.back.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Back {
    private Integer id;
    private String backSn;
    private Date returnDate;
    private Integer rentId;
    private String rentSn;
    private String problem;
    private String description;
    private BigDecimal payMoney;
    private String operName;
    private Date createTime;
    private Date updateTime;

    public Back() {
    }

    public Back(Integer id, String backSn, Date returnDate, Integer rentId, String rentSn, String problem, String description, BigDecimal payMoney, String operName, Date createTime, Date updateTime) {
        this.id = id;
        this.backSn = backSn;
        this.returnDate = returnDate;
        this.rentId = rentId;
        this.rentSn = rentSn;
        this.problem = problem;
        this.description = description;
        this.payMoney = payMoney;
        this.operName = operName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackSn() {
        return backSn;
    }

    public void setBackSn(String backSn) {
        this.backSn = backSn;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getRentSn() {
        return rentSn;
    }

    public void setRentSn(String rentSn) {
        this.rentSn = rentSn;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Back{" +
                "id=" + id +
                ", backSn='" + backSn + '\'' +
                ", returnDate=" + returnDate +
                ", rentId=" + rentId +
                ", rentSn='" + rentSn + '\'' +
                ", problem='" + problem + '\'' +
                ", description='" + description + '\'' +
                ", payMoney=" + payMoney +
                ", operName='" + operName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}