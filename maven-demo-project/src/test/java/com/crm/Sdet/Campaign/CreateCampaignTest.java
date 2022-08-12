package com.crm.Sdet.Campaign;

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
import comcast.vtiger.objectRepository.CampaignPage;
import comcast.vtiger.objectRepository.CampaignValidation;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;

public class CreateCampaignTest  extends BaseClass {
	
/*	
	@Test
	public void modifyContact() {
		System.out.println("Contact Modified");
	}
	*/

	@Test(groups={"smokeTest","regressionTest"})
	public  void CreateCampaign() throws Throwable {
		
		
		WebDriverUtility wlib=new WebDriverUtility();
		File_Utility p=new File_Utility();
		Java_utility j=new Java_utility();
		Excel_utility elib=new Excel_utility();
	
		int ranNo=j.getRandomNum();
		
		
		HomePage homepage=new HomePage(driver);
		homepage.more();
		homepage.Campaigns();
		
		CampaignPage campage=new CampaignPage(driver);
		campage.createCampaign();
	
	
		
		 String cName=elib.getExcelData("Campaign",0,0)+ranNo;
		 
		 campage.campaignName(cName);
		 campage.campaignSave();
		 
		 CampaignValidation cv=new CampaignValidation(driver);
		String actCname = cv.actualCampaignName();
		Assert.assertEquals(actCname.contains(cName), true);
		
		System.out.println("Actual Campaign Name is "+actCname);
		
		  homepage.SignOut(driver);
		  driver.quit();

	
		
		
		

	}

}
