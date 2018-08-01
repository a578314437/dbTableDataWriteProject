package cn.lixing.Oralce.Uilt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlSplit {
	public static Object[] colValues(String sql) {
		Object[] cols=null;
		String regex="((\\w+),)+\\w+";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(sql);
		if(matcher.find()) {
			cols=matcher.group(0).split(",");
		}
		return cols;
	}
	/**
	 * 获取表明字符串
	 * @param sql
	 * @return 返回表名字符串
	 */
	public static String getTableName(String sql) {
		String regex=".*into (\\w+)";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(sql);
		String tableName=null;
		if(matcher.find()) {
			tableName=matcher.group(1);
		}
		return tableName;
	}
	public static void main(String[] args) {
		String objs=getTableName("inser into user_111 (a,aa,aa,aaa,aaas,aaas) values(?,?,?,?)");
		System.out.println(objs);
		
	}
}
