package cn.edu.zut.CR.customer.dao.impl;

import cn.edu.zut.CR.customer.dao.CustomerDao;
import cn.edu.zut.CR.customer.entity.Customer;
import cn.edu.zut.CR.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> findAll() {
        String sql = "select * from tb_customer";
        List<Customer> list = new ArrayList<>();
        try(
              Connection connection = JdbcUtil.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sql);
              ResultSet resultSet = preparedStatement.executeQuery();
         ) {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setId(resultSet.getInt("id"));
                customer.setIdentity(resultSet.getString("identity"));
                customer.setGender(resultSet.getString("gender"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPhoneNumber(resultSet.getString("phone"));
                customer.setCreateTime(resultSet.getTimestamp("create_time"));
                customer.setUpdateTime(resultSet.getTimestamp("update_time"));
                list.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Customer getByCustomerName(String customername) {
        String sql = "select * from tb_customer where tb_customer.customer_name = ?";
        Customer customer = new Customer();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setString(1,customername);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery()
                    ) {
                if (resultSet.next()) {
                    customer.setCustomerName(resultSet.getString("customerName"));
                    customer.setId(resultSet.getInt("id"));
                    customer.setIdentity(resultSet.getString("identity"));
                    customer.setGender(resultSet.getString("gender"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhoneNumber(resultSet.getString("phone_number"));
                    customer.setCreateTime(resultSet.getTimestamp("create_time"));
                    customer.setUpdateTime(resultSet.getTimestamp("update_time"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public Customer getById(Integer id) {
        String sql = "select * from tb_customer where id = ?";
        Customer customer1 = new Customer();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer1.setCustomerName(resultSet.getString("customer_name"));
                customer1.setId(resultSet.getInt("id"));
                customer1.setIdentity(resultSet.getString("identity"));
                customer1.setGender(resultSet.getString("gender"));
                customer1.setAddress(resultSet.getString("address"));
                customer1.setPhoneNumber(resultSet.getString("phone"));
                customer1.setCreateTime(resultSet.getTimestamp("create_time"));
                customer1.setUpdateTime(resultSet.getTimestamp("update_time"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer1;
    }

    @Override
    public int insert(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0;
        String sql = "INSERT into tb_customer(tb_customer.identity,customer_name,gender,phone,address) values (?,?,?,?,?)";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getIdentity());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setString(3,customer.getGender());
            preparedStatement.setString(4,customer.getPhoneNumber());
            preparedStatement.setString(5,customer.getAddress());
            rows = preparedStatement.executeUpdate();
            if (rows!=0) {
                return 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int update(Customer customer) {
        String sql = "UPDATE tb_customer SET identity = ?, customer_name = ?, gender = ?, phone = ?,address = ? WHERE id = ?";

        int rows = 0;

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){

            preparedStatement.setString(1, customer.getIdentity());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setString(3,customer.getGender());
            preparedStatement.setString(4,customer.getPhoneNumber());
            preparedStatement.setString(5,customer.getAddress());
            preparedStatement.setInt(6, customer.getId());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete  from tb_customer where id = ?";
        Customer customer = new Customer();
        int rows = 0;
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setInt(1,id);
                rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }
}
