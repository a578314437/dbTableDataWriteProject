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
	 * ����Oracle���ݿ�
	 * @return ����oracle���Ӷ���
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
