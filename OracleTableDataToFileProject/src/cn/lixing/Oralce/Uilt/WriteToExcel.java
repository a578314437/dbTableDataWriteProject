package cn.lixing.Oralce.Uilt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static cn.lixing.Oralce.Uilt.PropertiesData.*;
import static cn.lixing.Oralce.Uilt.CloseUilt.*;

public class WriteToExcel {
	public static void writeToExcel(List<List<Object>> databaseList,String tableName) {
		BufferedOutputStream out=null;
		BufferedInputStream in=null;
		XSSFWorkbook workbook=null;
		XSSFRow row=null;
		try {
			in=new BufferedInputStream(new FileInputStream(getPropertiesData("databaseFile")));
			workbook=new XSSFWorkbook(in);
			XSSFSheet sheet=workbook.getSheet(tableName);
			int j=0;
			for(List<Object> obj:databaseList) {
				row=sheet.createRow(j);
				for(int i=0;i<obj.size();i++) {
					row.createCell(i).setCellValue(String.valueOf(obj.get(i)));
				}
				j++;
			}
			out = new BufferedOutputStream(new FileOutputStream(getPropertiesData("databaseFile")));
			workbook.write(out);
			System.out.println("表数据写入成功！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(out!=null) {
			close(out);
		}
		if(workbook!=null) {
			close(workbook);
		}
		
	}
	
}
