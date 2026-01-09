package cn.edu.zut.CR.car.dao.impl;

import cn.edu.zut.CR.VO.VIPC;
import cn.edu.zut.CR.car.dao.CarDao;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.car_customer.CarCustomer;
import cn.edu.zut.CR.util.JdbcUtil;
import cn.edu.zut.CR.util.ToConvertVO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> findByStatus(String status) {
        String sql = "select id,car_number,brand,type,rent_price,description,picture,status from tb_car where status = ? ORDER BY rent_price DESC;";
        List<Car> list = new ArrayList<>();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setString(1,status);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setCarNumber(resultSet.getString("car_number"));
                car.setBrand(resultSet.getString("brand"));
                car.setType(resultSet.getString("type"));
//                car.setColor(resultSet.getString("color"));
                car.setRentPrice(resultSet.getBigDecimal("rent_price"));
//                car.setDeposit(resultSet.getString("deposit"));
                car.setStatus(resultSet.getString("status"));
                car.setDescription(resultSet.getString("description"));
//                car.setCreateTime(resultSet.getTimestamp("create_time"));
//                car.setUpdateTime(resultSet.getTimestamp("update_time"));
                car.setPicture(resultSet.getString("picture"));
                list.add(car);
            }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Car> findAll() {
        String sql = "SELECT t1.id,t1.car_number,t1.brand,t1.type,t1.rent_price,t1.description,t1.picture,t1.status,t1.create_time,t2.plan_type,t2.plan_length FROM tb_car t1 LEFT JOIN tb_car_customer t2 ON t1.rent_price = t2.rent_price;";
        List<Car> list = new ArrayList<>();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                Car car = new Car();
                CarCustomer carCustomer = new CarCustomer();
                car.setId(resultSet.getInt("id"));
                car.setCarNumber(resultSet.getString("car_number"));
                car.setBrand(resultSet.getString("brand"));
                car.setType(resultSet.getString("type"));
//                car.setColor(resultSet.getString("color"));
                car.setRentPrice(resultSet.getBigDecimal("rent_price"));
//                car.setDeposit(resultSet.getString("deposit"));
                car.setStatus(resultSet.getString("status"));
                car.setDescription(resultSet.getString("description"));
                car.setCreateTime(resultSet.getTimestamp("create_time"));
                car.setPicture(resultSet.getString("picture"));
                carCustomer.setPlanType(resultSet.getString("plan_type"));
                carCustomer.setPlanLength(resultSet.getString("plan_length"));
                car.setCarCustomer(carCustomer);
                list.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Car getByCarName(String carNumber) {
        String sql = "SELECT t1.id,t1.car_number,t1.brand,t1.type,t1.rent_price,t1.description,t1.picture,t2.plan_type FROM tb_car t1 LEFT JOIN tb_car_customer t2 ON t1.rent_price = t2.rent_price where t1.car_number = ?";
        Car car = new Car();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setString(1,carNumber);
            try(
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                if (resultSet.next()) {
                    car.setId(resultSet.getInt("id"));
                    car.setCarNumber(resultSet.getString("car_number"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setType(resultSet.getString("type"));
//                    car.setColor(resultSet.getString("color"));
                    car.setRentPrice(resultSet.getBigDecimal("rent_price"));
//                    car.setDeposit(resultSet.getString("deposit"));
                    car.setStatus(resultSet.getString("status"));
                    car.setDescription(resultSet.getString("description"));
                    car.setCreateTime(resultSet.getTimestamp("create_time"));
                    car.setUpdateTime(resultSet.getTimestamp("update_time"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    @Override
    public Car getById(Integer id) {
        String sql = "SELECT t1.id,t1.car_number,t1.brand,t1.type,t1.rent_price,t1.description,t1.picture,t1.status,t1.create_time,t1.update_time,t2.plan_type,t2.plan_length FROM tb_car t1 LEFT JOIN tb_car_customer t2 ON t1.rent_price = t2.rent_price where t1.id = ?;";
        Car car1 = new Car();
        CarCustomer carCustomer = new CarCustomer();
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car1.setId(resultSet.getInt("id"));
                car1.setCarNumber(resultSet.getString("car_number"));
                car1.setBrand(resultSet.getString("brand"));
                car1.setType(resultSet.getString("type"));
//                car1.setColor(resultSet.getString("color"));
                car1.setRentPrice(resultSet.getBigDecimal("rent_price"));
//                car1.setDeposit(resultSet.getString("deposit"));
                car1.setStatus(resultSet.getString("status"));
                car1.setDescription(resultSet.getString("description"));
                car1.setCreateTime(resultSet.getTimestamp("create_time"));
                car1.setUpdateTime(resultSet.getTimestamp("update_time"));
                car1.setPicture(resultSet.getString("picture"));
                carCustomer.setPlanLength(resultSet.getString("plan_length"));
                carCustomer.setPlanType(resultSet.getString("plan_type"));
                car1.setCarCustomer(carCustomer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car1;
    }

    @Override
    public int insert(Car car) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0;
        String sql = "INSERT into tb_car(car_number, brand, type, rent_price, status, description, picture) values (?,?,?,?,?,?,?)";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getCarNumber());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getType());
//            preparedStatement.setString(4, car.getColor());
            preparedStatement.setBigDecimal(4, car.getRentPrice());
//            preparedStatement.setString(6, car.getDeposit());
            preparedStatement.setString(5, car.getStatus());
            preparedStatement.setString(6, car.getDescription());
            preparedStatement.setString(7, car.getPicture());
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
    public int update(Car car) {
        String sql = "UPDATE tb_car SET car_number = ?, brand = ?, type = ?, rent_price = ?,description = ?,picture = ? WHERE id = ?";

        int rows = 0;

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

            preparedStatement.setString(1, car.getCarNumber());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getType());
//            preparedStatement.setString(4, car.getColor());
            preparedStatement.setBigDecimal(4, car.getRentPrice());
//            preparedStatement.setString(6, car.getDeposit());
            preparedStatement.setString(5, car.getDescription());
            preparedStatement.setString(6, car.getPicture());
            preparedStatement.setInt(7, car.getId());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete  from tb_car where id = ?";
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

    @Override
    public int updateStatus(Integer id, String status) {

        String sql = "UPDATE tb_car SET status = ? WHERE id = ?";
        int rows = 0;
        try(
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1,status);
            preparedStatement.setInt(2,id);
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int updateStatus(Car car) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "UPDATE tb_car SET status = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getStatus());
            preparedStatement.setInt(2, car.getId());

            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement);
        }

        return rows;
    }
}
