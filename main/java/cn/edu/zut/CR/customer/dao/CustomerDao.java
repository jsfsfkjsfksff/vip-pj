package cn.edu.zut.CR.customer.dao;

import cn.edu.zut.CR.customer.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();

    /**
     * 根据用户名查询
     */
    Customer getByCustomerName(String customerName);

    /**
     * 根据ID查询
     */
    Customer getById(Integer id);

    /**
     * 添加
     */
    int insert(Customer customer);

    /**
     * 修改
     */
    int update(Customer customer);

    /**
     * 删除
     */
    int deleteById(Integer id);
}
