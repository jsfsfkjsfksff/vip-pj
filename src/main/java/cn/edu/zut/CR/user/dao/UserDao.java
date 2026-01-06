package cn.edu.zut.CR.user.dao;

import cn.edu.zut.CR.user.entity.User;

import java.util.List;

public interface UserDao {
        /**
         * 查询所有
         */
        List<User> findAll();

        /**
         * 根据用户名查询
         */
        User getByUsername(String username);

        /**
         * 根据ID查询
         */
        User getById(Integer id);

        /**
         * 添加
         */
        int insert(User user);

        /**
         * 修改
         */
        int update(User user);

        /**
         * 修改密码
         */
        int changePassword(User user);

        /**
         * 删除
         */
        int deleteById(Integer id);
    }
