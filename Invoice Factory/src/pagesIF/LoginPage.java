package pagesIF;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {
	@FindBy (id="login-form-email")
	WebElement email;
	
	@FindBy (id="login-pass")
	WebElement password;
	
	@FindBy (id="login-form-btn")
	WebElement submit;
	
	@FindBy (className="v-messages__message")
	List<WebElement> reqMailPassList;
	
	@FindBy (xpath="//*[@id=\"app\"]/div/main/div/div/div/div/form/div[1]/div[1]/div/div[2]/div/div/div")
	WebElement errorInvalidMail;
	
	@FindBy(xpath="//p[@class='body-2 my-0']")
	WebElement errorInvalidCredentials;
	
	@FindBy (xpath = "//div[@class='v-input__icon v-input__icon--append']/i")
	public
	WebElement showPassword;
	@FindBy (className ="v-messages__message")
	WebElement passSixChar;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public void fillInputs(String email, String password) {
		this.email.clear();
		this.password.clear();
		this.email.sendKeys(email);
		this.password.sendKeys(password);
	}
	
	public void loginBtn() {
		submit.click();
	}
	public String errorReqMail() {
		wait.until(ExpectedConditions.visibilityOfAllElements(reqMailPassList));
		return reqMailPassList.get(0).getText();
	}
	public String errorReqPass() {
		wait.until(ExpectedConditions.visibilityOfAllElements(reqMailPassList));
		return reqMailPassList.get(1).getText();
	}
	public String errorInvalidMail() {
		return errorInvalidMail.getText();
	}
	public String InvalidCredentials() {
		wait.until(ExpectedConditions.visibilityOf(errorInvalidCredentials));
		return errorInvalidCredentials.getText();
	}
	public String ShowPasswordBtn(){
		this.password.clear();
		this.password.sendKeys("sifra");
		if(showPassword.getText()== "visibility_off") {
			return "Password not visible";
		}else {
			return "Password is visible";
		}
	}
	public void leastSixGreaterTwenty() {
		String[] pass= {"@", "test","12345","UTI","qwerty","igorsaveskiigorsaveski12345","wqdsadaxvvx","asdfghjkl;qwertyuion"};
		password.sendKeys("1");
		for(String j : pass) {
			this.password.clear();
			this.password.sendKeys(j);
			wait.until(ExpectedConditions.visibilityOf(password));
			if(j.length()<6 || j.length()>20) {
				System.out.println(passSixChar.getText()+ ":" + j);
			} else {
				System.out.println( "Password valid lenght: " + j);
			}
		}		
	}
	public boolean submitbutton() {
		return submit.isDisplayed();
	}
	
}
