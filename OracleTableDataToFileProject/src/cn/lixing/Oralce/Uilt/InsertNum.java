package cn.lixing.Oralce.Uilt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertNum {
	/**
	 * ��ȡ����ֵƥ��ĸ���
	 * @param sql
	 * @return ���ظ���
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
