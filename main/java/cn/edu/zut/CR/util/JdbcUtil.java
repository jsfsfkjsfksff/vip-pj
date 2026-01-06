package cn.edu.zut.CR.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcUtil {
    /**
     * 四种数据库连接字符串和读取配置文件对象
     */
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Properties properties = new Properties();

    /**
     * 读取配置文件，获取数据库连接信息，并且加载驱动
     */
    static {
        try {
            // 通过IO流读取配置文件的内容
            InputStream input = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(input);
            driver = properties.getProperty("jdbc.mysql.driver");
            url = properties.getProperty("jdbc.mysql.url");
            username = properties.getProperty("jdbc.mysql.username");
            password = properties.getProperty("jdbc.mysql.password");
            // 加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 获取链接
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     */
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            // 在关闭之前判断，该对象是否为空
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     */
    public static void close(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
