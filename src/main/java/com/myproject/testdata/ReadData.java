package com.myproject.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadData {

	
	public void tc() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']")).click();
		
		ArrayList<String> userName=readExcelData(0);
		ArrayList<String> passWord=readExcelData(1);
		
		for(int i=0;i<userName.size();i++) {
		driver.findElement(By.id("ap_email")).sendKeys(userName.get(i));
		driver.findElement(By.id("ap_password")).sendKeys(passWord.get(i));
		driver.findElement(By.id("signInSubmit")).click();
	
		}
	}
	
	public ArrayList<String> readExcelData(int ColNo) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Naren\\Desktop\\TestData1.xls");
		HSSFWorkbook wb= new HSSFWorkbook(fis);
		HSSFSheet s=wb.getSheet("Sheet1");
		Iterator<Row> rowIterator=s.iterator();
		rowIterator.next();
		ArrayList<String> list=new ArrayList<String>();
			while(rowIterator.hasNext()) {
				
				list.add(rowIterator.next().getCell(ColNo).getStringCellValue());
			}
			return list;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		ReadData data= new ReadData();
		data.tc();
	}

}
