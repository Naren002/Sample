package com.myproject.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.base.TestBase;
import com.myproject.util.TestUtil;

public class LoginPage extends TestBase{

	TestUtil testutil;
	
	//Page-Factory  or Object Repository
	@FindBy(xpath="//a[@id='nav-link-yourAccount']")
	WebElement signIn;
	
	@FindBy(id="ap_email")
	WebElement user;
	
	@FindBy(id="ap_password")
	WebElement pswd;
	
	@FindBy(id="signInSubmit")
	WebElement signBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void tc() throws IOException {
		
		/*ReadData data= new ReadData();
		data.tc();*/
		signIn.click();
		
		ArrayList<String> userName=readExcelData(0);
		ArrayList<String> passWord=readExcelData(1);
		
		for(int i=0;i<userName.size();i++) {
		user.sendKeys(userName.get(i));	
		pswd.sendKeys(passWord.get(i));
		signBtn.click();
	
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
	

	
	
}
