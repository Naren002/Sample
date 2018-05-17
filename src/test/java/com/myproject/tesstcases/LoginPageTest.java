package com.myproject.tesstcases;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myproject.base.TestBase;
import com.myproject.pages.LoginPage;
import com.myproject.testdata.ReadData;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		Initialization();
		loginpage=new LoginPage();
	}
	
	@Test
	public void logintest() throws IOException {
		loginpage.tc();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}


