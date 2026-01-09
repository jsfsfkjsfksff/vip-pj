package cn.edu.zut.CR.rent.dao.impl;

import cn.edu.zut.CR.rent.dao.RentDao;
import cn.edu.zut.CR.VO.Rent;
import cn.edu.zut.CR.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentDaoImpl implements RentDao {

    @Override
    public List<Rent> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Rent> list = new ArrayList<>();

        try {
            connection = JdbcUtil.getConnection();
            String sql = "SELECT a.id, a.rent_sn, a.car_id, a.customer_id, a.back_date, a.rent_price, a.status, a.oper_name, a.create_time, a.update_time, b.brand, c.customer_name FROM tb_rent a JOIN tb_car b ON a.car_id = b.id JOIN tb_customer c ON a.customer_id = c.id";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rent rent = new Rent();
                rent.setId(resultSet.getInt("id"));
                rent.setRentSn(resultSet.getString("rent_sn"));
                rent.setCarId(resultSet.getInt("car_id"));
                rent.setBrand(resultSet.getString("brand"));
                rent.setCustomerId(resultSet.getInt("customer_id"));
                rent.setCustomerName(resultSet.getString("customer_name"));
//                rent.setRentDate(resultSet.getDate("rent_date"));
                rent.setBackDate(resultSet.getInt("back_date"));
                rent.setRentPrice(resultSet.getBigDecimal("rent_price"));
                rent.setStatus(resultSet.getString("status"));
                rent.setOperName(resultSet.getString("oper_name"));
                rent.setCreateTime(resultSet.getTimestamp("create_time"));
                rent.setUpdateTime(resultSet.getTimestamp("update_time"));
                list.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return list;
    }

    @Override
    public int insert(Rent rent) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "INSERT INTO tb_rent(rent_sn, car_id, customer_id, back_date, rent_price, " +
                    "status, oper_name, create_time, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rent.getRentSn());
            preparedStatement.setInt(2, rent.getCarId());
            preparedStatement.setInt(3, rent.getCustomerId());
            preparedStatement.setInt(4, rent.getBackDate());
            preparedStatement.setBigDecimal(5, rent.getRentPrice());
            preparedStatement.setString(6, rent.getStatus());
            preparedStatement.setString(7, rent.getOperName());
            preparedStatement.setTimestamp(8, new Timestamp(rent.getCreateTime().getTime()));
            preparedStatement.setTimestamp(9, new Timestamp(rent.getUpdateTime().getTime()));

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
            String sql = "DELETE FROM tb_rent WHERE id = ?";
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

    @Override
        public Rent getById(Integer id) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Rent rent = null;

            try {
                connection = JdbcUtil.getConnection();
                String sql = "SELECT id, rent_sn, car_id, customer_id, back_date, rent_price,status FROM tb_rent WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    rent = new Rent();
                    rent.setId(resultSet.getInt("id"));
                    rent.setRentSn(resultSet.getString("rent_sn"));
                    rent.setCarId(resultSet.getInt("car_id"));
                    rent.setCustomerId(resultSet.getInt("customer_id"));
//                    rent.setRentDate(resultSet.getDate("rent_date"));
                    rent.setBackDate(resultSet.getInt("back_date"));
                    rent.setRentPrice(resultSet.getBigDecimal("rent_price"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JdbcUtil.close(connection, preparedStatement, resultSet);
            }

            return rent;
        }

        @Override
    public int updateStatus(Rent rent) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "UPDATE tb_rent SET status = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rent.getStatus());
            preparedStatement.setInt(2, rent.getId());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }

        return rows;
    }

    @Override
    public List<Rent> findByStatus(String status) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Rent> list = new ArrayList<>();

        try {
            connection = JdbcUtil.getConnection();
            String sql = "SELECT a.id, a.rent_sn, a.car_id, a.customer_id, a.back_date, a.rent_price, " +
                    "b.car_number, c.customer_name FROM tb_rent a JOIN tb_car b ON a.car_id = b.id " +
                    "JOIN tb_customer c ON a.customer_id = c.id WHERE a.status = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, status);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rent rent = new Rent();
                rent.setId(resultSet.getInt("id"));
                rent.setRentSn(resultSet.getString("rent_sn"));
                rent.setCarId(resultSet.getInt("car_id"));
                rent.setCarNumber(resultSet.getString("car_number"));
                rent.setCustomerId(resultSet.getInt("customer_id"));
                rent.setCustomerName(resultSet.getString("customer_name"));
//                rent.setRentDate(resultSet.getDate("rent_date"));
                rent.setBackDate(resultSet.getInt("back_date"));
                rent.setRentPrice(resultSet.getBigDecimal("rent_price"));
                list.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }

        return list;
    }
}