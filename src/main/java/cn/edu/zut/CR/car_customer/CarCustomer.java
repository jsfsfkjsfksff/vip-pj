package cn.edu.zut.CR.car_customer;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CarCustomer {
    String planType;
    String planLength;
    BigDecimal rentPrice;
}
