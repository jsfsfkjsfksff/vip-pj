package cn.edu.zut.CR.report.dao;

import cn.edu.zut.CR.report.pojo.Report;

import java.util.List;

public interface ReportDao {
    /**
     * 统计客户性别
     */
    List<Report> getCustomerByGender();

    /**
     * 统计车辆类型
     */
    List<Report> getCarByType();

    /**
     * 统计年度出租量
     */
    List<Report> getRentCount(String year);
}