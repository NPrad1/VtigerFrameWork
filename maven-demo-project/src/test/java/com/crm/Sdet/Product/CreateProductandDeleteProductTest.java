package com.crm.Sdet.Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
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

public class CreateProductandDeleteProductTest extends BaseClass {

	@Test(groups={"smokeTest","regressionTest"})
	public  void CreateProductAndDeleteProduct() throws Throwable {
		
		
		Java_utility j=new Java_utility();
		Excel_utility elib=new Excel_utility();
		WebDriverUtility wlib=new WebDriverUtility();
		HomePage homepage=new HomePage(driver);
		homepage.Products();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.createProduct();
		
	
		
		
		int rv = j.getRandomNum();
		

		String pName=elib.getExcelData("Products",1,0)+rv;
		productpage.productName(pName);
		productpage.saveProduct();
		System.out.println("Product is saved");
		ProductValidation pv=new ProductValidation(driver);
		String actpName = pv.actualProductName();
		System.out.println("Actual Product Name is "+actpName);
		Assert.assertEquals(actpName.contains(pName), true);
		
		productpage.deleteProduct();
		System.out.println("Product is deleted");
		wlib.switchToAlertAndAccept(driver);
		
	
		homepage.SignOut(driver);
		driver.quit();
		
		
		
		
		
		
		

	}

}
