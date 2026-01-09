package cn.edu.zut.CR.util.dataUtil;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Properties;
@Data
public class p3 {
    private BigDecimal overMonth;
    private BigDecimal overQuarter;
    private BigDecimal overYear;

    public p3(Properties properties) {
        this.overMonth   = new BigDecimal(properties.getProperty("p3over_month"));
        this.overQuarter = new BigDecimal(properties.getProperty("p3over_quarter"));
        this.overYear    = new BigDecimal(properties.getProperty("p3over_year"));
    }
}
