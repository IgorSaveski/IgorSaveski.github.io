package testsIF;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesIF.BusinessPage;
import pagesIF.LoginPage;

public class BusinessPageTest extends InitTest {
	BusinessPage business;
	LoginPage login;

	@Test(priority = 16)
	public void viewDetails() {
		//view details,editovanje business-a i banke ,dodavanje i brisanje banke 
		business.businessTab();
		business.ViewDetails();
		Assert.assertEquals(business.nameOfBank(), "Generali");
		Assert.assertEquals(business.nameOFBusinnes(), "Bambi");
		business.addBank();
		Assert.assertEquals(business.verifyAddBank(), "SwissBank");
		business.deleteBank();
		business.save();
		Assert.assertEquals(business.verifySaveEdit(), "Business is successfully saved.");
	}
	@Test (priority = 17)
	//dodavanje novog biznisa
	public void newBusiness() {
		business = new BusinessPage(driver);
		business.newBusiness();
		Assert.assertEquals(business. newBusinessBank(), "Bank1");
		business.save();
		Assert.assertEquals(business. newBusinessVerify(), "Bulevar Zvezda");
	}
	@Test(priority =18)
	public void Logout(){
		business= new BusinessPage(driver);
		login = new LoginPage(driver);
		business.logOutBtn();
		Assert.assertTrue(login.submitbutton());
	}
}
