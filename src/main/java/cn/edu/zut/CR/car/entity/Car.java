package cn.edu.zut.CR.car.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * <p>
 * 车辆表
 * </p>
 *
 * @author WenruiLi
 * @since 2026-01-04
 */
@Getter
@Setter
@ToString
@TableName("tb_car")
public class Car implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 车辆ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 类型
     */
    private String type;

    /**
     * 颜色
     */
    private String color;

    /**
     * 出租价格
     */
    private BigDecimal rentPrice;

    /**
     * 出租押金
     */
    private BigDecimal deposit;

    /**
     * 状态（未出租,已出租）
     */
    private String status;

    /**
     * 描述
     */
    private String description;

    /**
     * 车辆图片
     */
    private String picture;

    private Timestamp createTime;

    private Timestamp updateTime;
}
