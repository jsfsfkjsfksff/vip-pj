package cn.edu.zut.CR.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 字符串工具类
 */
public class StringUtil {
	// 随机数
	public static Random random = new Random();
	// 设置格式化格式
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	/**
	 * 获取当前时间字符串
	 */
	public static String getStringTime(){
		// 获取当前系统时间
		Date date = new Date();
		// 返回格式化后的时间
		return sdf.format(date);
	}

	/**
	 * 验证字符串的有效性
	 * @param s 验证字符串
	 * @return 是否有效的布尔值
	 */
	public static boolean validateString(String s){
		// 如果字符串不为空返回true
		if(s != null && s.trim().length() > 0){
			return true;
		}
		return false;//字符串为空返回false
	}

	/**
	 * 验证浮点对象的有效性
	 * @param f 浮点对象
	 * @return 是否有效的布尔值
	 */
	public static boolean validateFloat(Float f){
		try {
			if(f != null && f > 0){
				return true;
			}
		} catch (Exception e) {}
		return false;
	}
    // ...

    /**
     * 生成单号
     * 规则: 固定的前缀 + 一个间隔符号 + 日期(4位年2位月2位日2位时2位分2位秒3毫秒) + 一个间隔符号 + 5位随机数
     */
    public static String createSn(String prefix){
        String time = sdf.format(new Date());
        int randomNum = random.nextInt(90000) + 10000;
        return prefix + "_" + time + "_" + randomNum;
    }
}
