package cn.lixing.Oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.lixing.Oralce.Uilt.PropertiesData;
import cn.lixing.Oralce.Uilt.TimeFormat;
@SuppressWarnings("all")
public class ConnectionOracle {
	private static PropertiesData psData=null;
	private static Connection connection=null;
	/**
	 * 连接Oracle数据库
	 * @return 返回oracle连接对象
	 */
	public static Connection connection() {
		psData=new PropertiesData();
		try {
			Class.forName(psData.getPropertiesData("device"));
			connection=DriverManager.getConnection(
					psData.getPropertiesData("url"), 
					psData.getPropertiesData("username"), 
					psData.getPropertiesData("password")
					);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return connection;
	}
}
