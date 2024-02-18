package org.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample extends BaseClass{

	public static void main(String[] args) throws IOException {
		
		browserLaunch("edge");
		
		urlLaunch("https://www.facebook.com/");
		
		maximize();
		
		implicitlyWait(20);
		
		LoginPage l=new LoginPage();   
		
		sendKeys(l.getTxtUsername(), "sera");
		
		sendKeys(l.getTxtPassword(), "rajs");
		
		
		
		
	}
	
}
