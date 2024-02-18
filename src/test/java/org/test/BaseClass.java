package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public static WebDriver edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		return driver;
	}
	
	public static WebDriver browserLaunch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		return driver;
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void implicitlyWait(int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
        a.moveToElement(target).perform();
	}
	
	public static void dragAndDrop(WebElement src,WebElement tar) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, tar).perform();
	}
	
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	
	public static void refresh() {
		driver.navigate().refresh();

	}
	
	public static String readExcel(String filename,String sheet,int row,int cel) throws IOException {
		File f=new File("C:\\Users\\dell\\eclipse-workspace\\Maven_06.00Pm_Jan2024\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		FileInputStream st=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell cell = r.getCell(cel);
		int type = cell.getCellType();
		String value=null;
		if(type==1) {
			 value = cell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
				 value = sd.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long num=(long)numericCellValue;
				 value = String.valueOf(num);
			}
		}
		return value;

	}
	
	
	
	
}
