package cn.edu.zut.CR.car.dao;

import cn.edu.zut.CR.VO.VIPC;
import cn.edu.zut.CR.car.entity.Car;
import cn.edu.zut.CR.car.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 车辆表 Mapper 接口
 * </p>
 *
 * @author WenruiLi
 * @since 2026-01-04
 */
public interface CarDao  {
    /**
     * 根据状态查询
     */
    List<Car> findByStatus(String status);
    /**
     * 查询所有
     */
    List<Car> findAll();

    /**
     * 根据用户名查询
     */
    Car getByCarName(String carName);

    /**
     * 根据ID查询
     */
    Car getById(Integer id);

    /**
     * 添加
     */
    int insert(Car car);

    /**
     * 修改
     */
    int update(Car car);

    /**
     * 删除
     */
    int deleteById(Integer id);
    /**
     * 更改状态
     */
    int updateStatus(Integer id, String status);

    /**
     * 修改状态
     */
    int updateStatus(Car car);
}
