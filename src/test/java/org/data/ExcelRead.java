package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		
		File f=new File("C:\\Users\\dell\\eclipse-workspace\\Maven_06.00Pm_Jan2024\\src\\test\\resources\\Excel\\Datas.xlsx");
		FileInputStream st=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(1);
		Cell cell = r.getCell(2);
		System.out.println(cell);
		//type
		int type = cell.getCellType();
		System.out.println(type);
		
		//type 1 --string
		//type 0 --number,date
		
		String value=null;
		if(type==1) {
			 value = cell.getStringCellValue();
			System.out.println(value);
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
				 value = sd.format(dateCellValue);
				System.out.println(value);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long num=(long)numericCellValue;
				 value = String.valueOf(num);
				System.out.println(value);
			}
		}
		
		
		
	}
	
}
