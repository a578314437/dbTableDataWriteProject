package cn.lixing.Oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.lixing.Oralce.Uilt.TimeFormat;
import static cn.lixing.Oralce.Uilt.InsertNum.*;
public class OralceAction {
	private static Connection connection=null;
	private static PreparedStatement pmt=null;
	private static String sql=null;
	private static ResultSet result;
	/**
	 * 插入数据
	 * @param colNames 存储列值数组
	 * @param values 存储值数组
	 * @param TableName 表名
	 * @return
	 */
	public static Boolean insert(Object[] colNames,Object[] values,String TableName) {
		ArrayList<Object> colNamesList=new ArrayList<>();
		ArrayList<Object> ValuesList=new ArrayList<>();
		String colNameStr=null;
		try {
			connection=ConnectionOracle.connection();
			for(int colNum=0;colNum<colNames.length;colNum++) {
				colNamesList.add(colNames[colNum]);
				ValuesList.add(values[colNum]);
			}
			colNameStr=colNamesList.toString().replace("[", "").replace("]", "");
			Object valuesStr=ValuesList.toString().replace("[", "").replace("]", "").replaceAll("\\w+_", "?").replace("?date", "to_date");
			sql="INSERT into "+TableName+ "("+colNameStr+")"+" VALUES("+valuesStr+")";
			pmt=connection.prepareStatement(sql);
			String date=TimeFormat.DateFormat(new Date(System.currentTimeMillis()));
			for(int i=1;i<getNum(sql);i++) {
				pmt.setString(i, date);
			}
			pmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			return false;
		}
		try {
			pmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 更新数据
	 * @param colNames
	 * @param values
	 * @param TableName
	 * @param conditionValue
	 */
	public static void updata(Object[] colNames,Object[] values,String TableName,String conditionValue,Object col) {
		connection=ConnectionOracle.connection();
		try {
			for(int i=0;i<colNames.length;i++) {
				sql="update "+TableName+" set "+colNames[i]+"="+values[i]+" where "+conditionValue+"=?";
				pmt=connection.prepareStatement(sql);
				pmt.setObject(1, col);
				pmt.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("更新成功！");
	}
	/**
	 * 查询数据
	 * @param TableName
	 * @return
	 */
	public static List<List<Object>> select(String TableName) {
		List<Object>rowListDatas=new ArrayList<>();
		List<List<Object>> listArr=null;
		List<Object>ColListNames=new ArrayList<>();
		ResultSetMetaData meta=null;
		int colNum=0;
		connection=ConnectionOracle.connection();
		try {
			sql="select * from "+TableName;
			pmt=connection.prepareStatement(sql);
			result=pmt.executeQuery();
			meta = result.getMetaData();
			colNum=meta.getColumnCount();
			for(int i=1;i<=colNum;i++) {
				ColListNames.add(meta.getColumnLabel(i));
			}
			while(result.next()) {
			for(int i=0;i<meta.getColumnCount();i++) {
				Object colVaules=result.getObject(i+1);
				rowListDatas.add(colVaules);
			}
			}
			listArr = new ArrayList<>();      
			listArr.add(ColListNames);
	        int arrSize = rowListDatas.size()%colNum==0?rowListDatas.size()/colNum:rowListDatas.size()/colNum+1;      
	        for(int i=0;i<arrSize;i++) {      
	        	List<Object>rowListData=new ArrayList<>();      
	            for(int j=i*colNum;j<=colNum*(i+1)-1;j++) {      
	                if(j<=rowListDatas.size()-1) {      
	                	rowListData.add(rowListDatas.get(j));      
	                }      
	            }      
	            listArr.add(rowListData);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return listArr;
	}
	public static void main(String[] args) {
		System.out.println(select("TB_DEVICE_EDU"));
	}
}
