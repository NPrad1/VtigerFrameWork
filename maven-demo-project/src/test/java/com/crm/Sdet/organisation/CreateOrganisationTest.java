package com.crm.Sdet.organisation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_utility;
import comcast.vtiger.genericUtility.Java_utility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.OrganisationPage;
import comcast.vtiger.objectRepository.OrganisationValidation;

//@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass)
public class CreateOrganisationTest extends BaseClass {
	
	/*@Test
	public void deleteContact() {
		System.out.println("Delete contact");
	}
	*/
	
	@Test(groups={"smokeTest","regressionTest"})
	public  void CreateOrganisation() throws Throwable {
	
		Java_utility jlib=new Java_utility();
		Excel_utility elib=new Excel_utility();
		
		HomePage homepage=new HomePage(driver);
		homepage.Organisation();
		OrganisationPage orgpage=new OrganisationPage(driver);
		orgpage.organisationPlus();
		
		int ranNo = jlib.getRandomNum();
		
		//intensionally failing test script
		//Assert.assertEquals(true, false);
		
		String orgName=elib.getExcelData("Organisation",2,0)+ranNo;
		
		orgpage.organisationName(orgName);
		orgpage.organisationSave();
		
		OrganisationValidation ov =new OrganisationValidation(driver);
		String actOrg = ov.actualOrganisationName();
		System.out.println( "Actual Organisation is "+actOrg);
		Assert.assertEquals(actOrg.contains(orgName), true);
		homepage.SignOut(driver);
		driver.quit();
		

	}

}
