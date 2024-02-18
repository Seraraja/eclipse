package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel {

	public static void main(String[] args) throws IOException {
		//replace value
		File f=new File("C:\\Users\\dell\\eclipse-workspace\\Maven_06.00Pm_Jan2024\\src\\test\\resources\\Excel\\data.xlsx");
		FileInputStream st=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
		Sheet s = w.getSheet("sera");
		Row r = s.getRow(1);
		Cell cell = r.getCell(1);
		String value = cell.getStringCellValue();
		if(value.equals("facebook")) {
			cell.setCellValue("snapchat");
		}
		
		FileOutputStream ot=new FileOutputStream(f);
		w.write(ot);
		System.out.println("Done");
		
	}
	
}
