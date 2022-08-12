package com.crm.Sdet.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_utility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import comcast.vtiger.objectRepository.ProductPage;
import comcast.vtiger.objectRepository.ProductValidation;

public  class CreateProductTest extends BaseClass {

	@Test(groups={"smokeTest","regressionTest"})
	public void CreateProduct() throws Throwable  {
		
		Java_utility j=new Java_utility();
		Excel_utility elib=new Excel_utility();
		
		int ranNo=j.getRandomNum();
	
		HomePage homepage=new HomePage(driver);
		homepage.Products();
		ProductPage productpage=new ProductPage(driver);
		productpage.createProduct();
		
		
		
		
		 String pName=elib.getExcelData("Products",1, 0)+ranNo;
		 Thread.sleep(2000);
		 productpage.productName(pName);
		 productpage.saveProduct();
		 
		  ProductValidation pv=new ProductValidation(driver);
		  String actPname = pv.actualProductName();
		  Assert.assertEquals(actPname.contains(pName), true);
		  System.out.println("Actual Product name is "+actPname);
		
		  
		  homepage.SignOut(driver);
		  driver.quit();
		 
		 
		 
		
		

	}

}
