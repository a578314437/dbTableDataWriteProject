package cn.lixing.Oralce.Uilt;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class TimeFormat {
	/**
	 * ��ʽ��ʱ���ʽ����
	 * @param date 
	 * @return ���ظ�ʽ�����ʱ���ַ���
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
