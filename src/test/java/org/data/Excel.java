package org.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException {
		
		// 1.File location
		File f=new File("C:\\Users\\dell\\eclipse-workspace\\Maven_06.00Pm_Jan2024\\src\\test\\resources\\Excel\\Datas.xlsx");
		
		// 2.Fileinputstream
		FileInputStream st=new FileInputStream(f);
		
		// 3.Workbook
		Workbook w=new XSSFWorkbook(st);
		
		// 4.getsheet
		Sheet s = w.getSheet("Sheet1");
		
		// 5.getrow
		Row r = s.getRow(2);
		
		// 6.get cell
		Cell c = r.getCell(0);
		System.out.println(c);   // manoj----"manoj',   12345--->"12345" 12.35--->"12.35"
		
		String string = c.toString();
		System.out.println(string);
		
		//row size
		int rowSize = s.getPhysicalNumberOfRows();
		System.out.println(rowSize);
		
		int cellSize = r.getPhysicalNumberOfCells();
		System.out.println(cellSize);
		
		for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
			Row row = s.getRow(i);
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(j);
				System.out.println(cell);
			}
		}
		
	}
}
