package cn.lixing.Oralce.Uilt;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class TimeFormat {
	/**
	 * 格式化时间格式函数
	 * @param date 
	 * @return 返回格式化后的时间字符串
	 */
	public static String DateFormat(Date date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime=format.format(date);
		return dateTime;
	}
	public static void main(String[] args) {
		System.out.println(DateFormat(new Date(System.currentTimeMillis())));
	}
}
