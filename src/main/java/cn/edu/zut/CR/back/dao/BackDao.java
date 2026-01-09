package cn.edu.zut.CR.back.dao;

import cn.edu.zut.CR.back.entity.Back;

import java.util.List;

public interface BackDao {
    /**
     * 查询所有
     */
    List<Back> findAll();

    /**
     * 添加
     */
    int insert(Back back);

    /**
     * 删除
     */
    int deleteById(Integer id);
}