package cn.lixing.Oracle;

import static cn.lixing.Oracle.OralceAction.select;
import static cn.lixing.Oralce.Uilt.WriteToExcel.*;
import static cn.lixing.Oralce.Uilt.PropertiesData.*;
public class TableDataWriteFile {
	public static void main(String[] args) {
		String TableName=getPropertiesData("WriteDataTable");
		writeToExcel(select(TableName),TableName);
	}
}
