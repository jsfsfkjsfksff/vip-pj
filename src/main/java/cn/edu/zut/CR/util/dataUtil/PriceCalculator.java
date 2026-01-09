package cn.edu.zut.CR.util.dataUtil;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class PriceCalculator {
        public static BigDecimal calculate(String level, String type) {
            Properties properties = new Properties();
            InputStream resourceAsStream = PriceCalculator.class.getClassLoader().getResourceAsStream("price.properties");
            try {
                properties.load(resourceAsStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            p1 p1 = new p1(properties);
            p2 p2 = new p2(properties);
            p3 p3 = new p3(properties);
            if ("p1".equals(level)) {
                if ("overMonth".equals(type)) return p1.getOverMonth();
                if ("overQuarter".equals(type)) return p1.getOverQuarter();
                if ("overYear".equals(type)) return p1.getOverYear();
            } else if ("p2".equals(level)) {
                if ("overMonth".equals(type)) return p2.getOverMonth();
                if ("overQuarter".equals(type)) return p2.getOverQuarter();
                if ("overYear".equals(type)) return p2.getOverYear();
            } else if ("p3".equals(level)) {
                if ("overMonth".equals(type)) return p3.getOverMonth();
                if ("overQuarter".equals(type)) return p3.getOverQuarter();
                if ("overYear".equals(type)) return p3.getOverYear();
            }
            return null;
        }
}
