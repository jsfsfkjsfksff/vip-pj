package cn.edu.zut.CR.report.dao.impl;

import cn.edu.zut.CR.report.pojo.Report;
import cn.edu.zut.CR.report.dao.ReportDao;
import cn.edu.zut.CR.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {
    @Override
    public List<Report> getCustomerByGender() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Report> list = new ArrayList<>();

        try {
            connection = JdbcUtil.getConnection();
            String sql = "SELECT gender name,count(1) value FROM tb_customer GROUP BY gender";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Report report = new Report();
                report.setName(resultSet.getString("name"));
                report.setValue(resultSet.getInt("value"));
                list.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return list;
    }

    @Override
    public List<Report> getCarByType() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Report> list = new ArrayList<>();

        try {
            connection = JdbcUtil.getConnection();
            String sql = "SELECT type name,count(1) value FROM tb_car GROUP BY type";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Report report = new Report();
                report.setName(resultSet.getString("name"));
                report.setValue(resultSet.getInt("value"));
                list.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return list;
    }

    @Override
    public List<Report> getRentCount(String year) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Report> list = new ArrayList<>();

        try {
            connection = JdbcUtil.getConnection();
            String sql = "SELECT concat(a.month, '月') AS name, ifnull(b.value, 0) AS value FROM ( SELECT '01' AS month UNION SELECT '02' UNION SELECT '03' UNION SELECT '04' UNION SELECT '05' UNION SELECT '06' UNION SELECT '07' UNION SELECT '08' UNION SELECT '09' UNION SELECT '10' UNION SELECT '11' UNION SELECT '12') a LEFT JOIN ( SELECT month(create_time) month, count(1) value FROM tb_rent WHERE year(create_time) = ? GROUP BY month ORDER BY month ) b ON a.month = b.month\n";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, year);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Report report = new Report();
                report.setName(resultSet.getString("name"));
                report.setValue(resultSet.getInt("value"));
                list.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return list;
    }
}