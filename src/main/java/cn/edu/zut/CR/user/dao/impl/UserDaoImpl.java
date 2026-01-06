package cn.edu.zut.CR.user.dao.impl;

import cn.edu.zut.CR.user.dao.UserDao;
import cn.edu.zut.CR.user.entity.User;
import cn.edu.zut.CR.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        String sql = "select * from tb_user";
        List<User> list = new ArrayList<>();
        try(
              Connection connection = JdbcUtil.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sql);
              ResultSet resultSet = preparedStatement.executeQuery();
         ) {
            while (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                user.setNickName(resultSet.getString("nick_name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setCreateTime(resultSet.getTimestamp("create_time"));
                user.setUpdateTime(resultSet.getTimestamp("update_time"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public User getByUsername(String username) {
        String sql = "select * from tb_user where username = ?";
        User user = new User();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setString(1,username);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery()
                    ) {
                if (resultSet.next()) {
                    user.setUserName(resultSet.getString("username"));
                    user.setId(resultSet.getInt("id"));
                    user.setNickName(resultSet.getString("nick_name"));
                    user.setPassword(resultSet.getString("password"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    user.setCreateTime(resultSet.getTimestamp("create_time"));
                    user.setUpdateTime(resultSet.getTimestamp("update_time"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from tb_user where id = ?";
        User user1 = new User();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user1.setUserName(resultSet.getString("username"));
                user1.setId(resultSet.getInt("id"));
                user1.setNickName(resultSet.getString("nick_name"));
                user1.setPassword(resultSet.getString("password"));
                user1.setEmail(resultSet.getString("email"));
                user1.setPhoneNumber(resultSet.getString("phone_number"));
                user1.setCreateTime(resultSet.getTimestamp("create_time"));
                user1.setUpdateTime(resultSet.getTimestamp("update_time"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user1;
    }

    @Override
    public int insert(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0;
        String sql = "INSERT into tb_user(username,nick_name,password,email,phone_number) values (?,?,?,?,?)";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2,user.getNickName());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getPhoneNumber());
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
    public int update(User user) {
        String sql = "UPDATE tb_user SET username = ?, nick_name = ?, email = ?, phone_number = ? WHERE id = ?";

        int rows = 0;

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getNickName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setInt(5, user.getId());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int changePassword(User user) {
        String sql = "UPDATE tb_user SET password = ? WHERE id = ?";

        int rows = 0;

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2, user.getId());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete  from tb_user where id = ?";
        User user = new User();
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
