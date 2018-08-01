package cn.lixing.Oralce.Uilt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertNum {
	/**
	 * 获取插入值匹配的个数
	 * @param sql
	 * @return 返回个数
	 */
	public static int getNum(String sql) {
	 Pattern p = Pattern.compile("\\?",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sql);
        int count = 0;
        while(m.find()){
              count ++;
        }
        return count;
	  
	}
}	
