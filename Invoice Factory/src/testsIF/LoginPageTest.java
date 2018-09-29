package testsIF;

import org.junit.Assert;
import org.testng.annotations.Test;

import pagesIF.BusinessPage;
import pagesIF.InvoicesPage;
import pagesIF.LoginPage;

public class LoginPageTest extends InitTest {
  LoginPage login;
  InvoicesPage invoices;
  BusinessPage business;

  String BASE_URL ="http://app.invoice-factory.source-code.rs";
  @Test(priority = 0)
	public void loginDomainName() {
	  //email withoud domain name and invalid pass
		login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.fillInputs("igorsav90@", "password");
		login.loginBtn();
		 Assert.assertEquals(login.errorInvalidMail(), "The email field must be a valid email.");
  }
  @Test(priority = 1)
	public void invalidMail() {
	  //Login with invalid email and correct password
		login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.fillInputs("igorsav@gmail.com", "qwe123");
		login.loginBtn();
		Assert.assertEquals(login.InvalidCredentials(), "Invalid credentials.");
  }
  @Test(priority = 2)
	public void invalidPass() {
	  //Login with correct email and invalid password
		login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.fillInputs("igorsav90@gmail.com", "qwe1234");
		login.loginBtn();
		Assert.assertEquals(login.InvalidCredentials(), "Invalid credentials.");
}
  @Test(priority = 3)
	public void emptyField() {
	  //Login with empty email and empty password
		login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.loginBtn();
		Assert.assertEquals(login.errorReqMail(), "The email field is required.");
		Assert.assertEquals(login.errorReqPass(), "The password field is required.");
  }
  
  @Test(priority = 4)
	public void ShowPassword() {
	  // Show password
		login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.ShowPasswordBtn();
		login.showPassword.click();
		login.ShowPasswordBtn();
}
  @Test(priority = 5)
 	public void uppercasePass() {
 	  //Login with correct email and correct uppercase password
 		login = new LoginPage(driver);
 		business = new BusinessPage(driver);
 		driver.get(BASE_URL);
 		login.fillInputs("igorsav90@gmail.com", "QWE123");
 		login.loginBtn();
 		Assert.assertEquals(login.InvalidCredentials(), "Invalid credentials.");;
   }
  @Test(priority = 6)
	public void uppercaseMail() {
	  //Login with correct uppercase email and correct password
		login = new LoginPage(driver);
		business = new BusinessPage(driver);
		driver.get(BASE_URL);
		login.fillInputs("IGORSAV90@GMAIL.COM", "qwe123");
		login.loginBtn();
		business.logOutBtn();
		Assert.assertTrue(login.submitbutton());
  }
  @Test(priority = 7)
	public void passleast6greater20() {
	  // Password length between 6 and 20
		login = new LoginPage(driver);
		driver.get(BASE_URL);
		login.leastSixGreaterTwenty();
}
  @Test(priority = 8)
	public void login() {
	  //Login with correct  email and correct password
		login = new LoginPage(driver);
		invoices = new InvoicesPage(driver);
		driver.get(BASE_URL);
		login.fillInputs("igorsav90@gmail.com", "qwe123");
		login.loginBtn();
		Assert.assertEquals("Igor", invoices.userNameText());
		
}
  
}
