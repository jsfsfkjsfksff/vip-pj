package cn.edu.zut.CR.rent.dao;

import cn.edu.zut.CR.VO.Rent;

import java.util.List;

public interface RentDao {
    List<Rent> findAll();
    int insert(Rent rent);
    int deleteById(Integer id);
    Rent getById(Integer id);

    int updateStatus(Rent rent);

    List<Rent> findByStatus(String cubOuter);
}
