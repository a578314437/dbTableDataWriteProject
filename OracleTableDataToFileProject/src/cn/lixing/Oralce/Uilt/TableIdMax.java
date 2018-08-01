package cn.lixing.Oralce.Uilt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.lixing.Oracle.ConnectionOracle;

public class TableIdMax {
	/**
	 * 获取对应表的最大行数
	 * @param TableName
	 * @param colName
	 * @return 返回最大行数
	 */
	public static int getTableIdMax(String TableName,Object colName) {
		Connection connection=ConnectionOracle.connection();
		PreparedStatement pmt=null;
		ResultSet rs=null;
		int colMax=0;
		try {
			String sql="SELECT MAX("+colName+") FROM "+TableName+"";
			System.out.println(sql);
			pmt=connection.prepareStatement(sql);
			rs=pmt.executeQuery();
			while(rs.next()) {
				colMax=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colMax;
	}
	public static void main(String[] args) {
		System.out.println(getTableIdMax("TB_PQ_QRCODE","QRCODE_ID"));
	}
}
