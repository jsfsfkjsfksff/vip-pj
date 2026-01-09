package cn.edu.zut.CR.back.dao.impl;

import cn.edu.zut.CR.back.dao.BackDao;
import cn.edu.zut.CR.back.entity.Back;
import cn.edu.zut.CR.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BackDaoImpl implements BackDao {
    @Override
    public List<Back> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Back> list = new ArrayList<>();

        try {
            connection = JdbcUtil.getConnection();
            String sql = "SELECT a.id, a.back_sn, a.return_date, a.rent_id, a.problem, a.description, a.pay_money, " +
                    "a.oper_name, a.create_time, a.update_time, b.rent_sn " +
                    "FROM tb_back a JOIN tb_rent b ON a.rent_id = b.id";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Back back = new Back();
                back.setId(resultSet.getInt("id"));
                back.setBackSn(resultSet.getString("back_sn"));
                back.setReturnDate(resultSet.getDate("return_date"));
                back.setRentId(resultSet.getInt("rent_id"));
                back.setRentSn(resultSet.getString("rent_sn"));
                back.setProblem(resultSet.getString("problem"));
                back.setDescription(resultSet.getString("description"));
                back.setPayMoney(resultSet.getBigDecimal("pay_money"));
                back.setOperName(resultSet.getString("oper_name"));
                back.setCreateTime(resultSet.getTimestamp("create_time"));
                back.setUpdateTime(resultSet.getTimestamp("update_time"));
                list.add(back);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return list;
    }

    @Override
    public int insert(Back back) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "INSERT INTO tb_back(back_sn, rent_id, problem, description, pay_money, " +
                    "oper_name, create_time, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, back.getBackSn());
//            preparedStatement.setDate(2, new Date(back.getReturnDate().getTime()));
            preparedStatement.setInt(2, back.getRentId());
            preparedStatement.setString(3, back.getProblem());
            preparedStatement.setString(4, back.getDescription());
            preparedStatement.setBigDecimal(5, back.getPayMoney());
            preparedStatement.setString(6, back.getOperName());
            preparedStatement.setTimestamp(7, new Timestamp(back.getCreateTime().getTime()));
            preparedStatement.setTimestamp(8, new Timestamp(back.getUpdateTime().getTime()));

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }

        return rows;
    }

    @Override
    public int deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "DELETE FROM tb_back WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }

        return rows;
    }
}