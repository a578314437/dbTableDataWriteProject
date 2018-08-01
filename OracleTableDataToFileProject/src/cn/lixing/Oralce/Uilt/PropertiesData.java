package cn.lixing.Oralce.Uilt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesData {
	/**
	 * 读取properties文件内容
	 * @param keyVaule
	 * @return 返回对应key的值
	 */
	public static String getPropertiesData(String keyVaule) {
		String rootPath=System.getProperty("user.dir");
		String configPath=rootPath+"\\config\\jdbc.properties";
		BufferedInputStream inputStream=null;
		Properties ps=null;
		
		try {
			inputStream=new BufferedInputStream(new FileInputStream(configPath));
			ps=new Properties();
			ps.load(inputStream);
		} catch (FileNotFoundException e) {
			try {
				inputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ps.getProperty(keyVaule);
	}
	public static void main(String[] args) {
		System.out.println(getPropertiesData("databaseFile"));
	}
}
