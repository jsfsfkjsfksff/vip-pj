package cn.edu.zut.CR.rent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 出租单表
 * </p>
 *
 * @author WenruiLi
 * @since 2026-01-06
 */
@Getter
@Setter
@ToString
@TableName("tb_rent")
public class rent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 出租单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出租单号
     */
    private String rentSn;

    /**
     * 车辆ID
     */
    private Integer carId;

    /**
     * 客户ID
     */
    private Integer customerId;

    /**
     * 起租时间
     */
    private LocalDate rentDate;

    /**
     * 归还时间
     */
    private LocalDate backDate;

    /**
     * 出租价格
     */
    private BigDecimal rentPrice;

    /**
     * 状态（未归还,已归还）
     */
    private String status;

    /**
     * 操作人
     */
    private String operName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
