package cn.edu.zut.CR.util.dataUtil;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Properties;
@Data
public class p1 {
    private BigDecimal overMonth;
    private BigDecimal overQuarter;
    private BigDecimal overYear;
    public p1(Properties properties) {
        this.overMonth   = new BigDecimal(properties.getProperty("p1over_month"));
        this.overQuarter = new BigDecimal(properties.getProperty("p1over_quarter"));
        this.overYear    = new BigDecimal(properties.getProperty("p1over_year"));
    }
}

