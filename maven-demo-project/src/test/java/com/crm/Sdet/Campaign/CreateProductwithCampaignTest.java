package com.crm.Sdet.Campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import comcast.vtiger.objectRepository.CampaignPage;
import comcast.vtiger.objectRepository.CampaignValidation;
import comcast.vtiger.objectRepository.CampaignWindowPopUp;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import comcast.vtiger.objectRepository.ProductPage;
import comcast.vtiger.objectRepository.ProductValidation;

public class CreateProductwithCampaignTest extends BaseClass{

	@Test(groups={"smokeTest","regressionTest"})
	public  void CreateProductwithCampaign() throws Throwable {
	
	
		
		
		
		Java_utility jlib=new Java_utility();
		Excel_utility elib=new Excel_utility();
		WebDriverUtility wlib=new WebDriverUtility();
	
	
		HomePage homepage=new HomePage(driver);
		homepage.Products();
	
		ProductPage productpage=new ProductPage(driver);
		productpage.createProduct();
		
		
		int rv=jlib.getRandomNum();
		
		String pName = elib.getExcelData("Products",2, 0)+rv;
		productpage.productName(pName);
		productpage.saveProduct();
		
		ProductValidation pv=new ProductValidation(driver);
		String acpName = pv.actualProductName();
		System.out.println("Product created sucessfully"+acpName);
		Assert.assertEquals(acpName.contains(pName), true);
		
		homepage.Home();
		WebElement more = driver.findElement(By.linkText("More"));
		wlib.mouseOverOnElement(driver, more);
		
		homepage.Campaigns();
		CampaignPage campaignpage=new CampaignPage(driver);
		campaignpage.createCampaign();
		
		String cName=elib.getExcelData("Campaign", 0, 0);
		
		campaignpage.campaignName(cName);
		campaignpage.addProductCampaign();
		
		

		wlib.switchToWindow(driver,"Produts&action");
		CampaignWindowPopUp campwinpop=new CampaignWindowPopUp(driver);
		
		campwinpop.productNameCapmaign(pName);
		Thread.sleep(2000);
		campwinpop.searchProductCampaign(driver,pName);
		
		//driver.findElement(By.xpath("//a[.='"+pName+"']")).click();
		
		wlib.switchToWindow(driver, "Campaigns&action");
		
		
			
		campaignpage.campaignSave();
	
		System.out.println("Campaign created "+cName);
		
		CampaignValidation cv=new CampaignValidation(driver);
		String actcName = cv.actualCampaignName();
		
		Assert.assertEquals(actcName.contains(cName),true);
		
		homepage.SignOut(driver);
		driver.quit();

	}

}
