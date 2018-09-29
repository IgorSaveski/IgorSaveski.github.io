package pagesIF;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessPage extends PageObject {
	@FindBy (id="nav-bar-business")
	WebElement navigateBusiness;
	
	@FindBy (xpath ="//h4[@class='invoice-factory-header-title ml-5 mt-5']")
	WebElement businessListText;
	//dodavanje novog biznisa
	@FindBy (id="add-new-business")
	WebElement addNewBusiness;
	@FindBy (id="business-form-country")
	WebElement country;
	@FindBy (xpath="//div[contains(text(),'Andorra')]")
	WebElement countryAndorra;
	@FindBy (id="business-form-city")
	WebElement city;
	@FindBy (id="business-form-street")
	WebElement street;
	@FindBy (id="business-form-zip")
	WebElement zip;
	@FindBy (id="business-form-reg-num")
	WebElement registryNumber;
	@FindBy (xpath="//strong[contains(@id,'business-name-')]")
	List<WebElement> businessName;
	@FindBy (xpath="//div[contains(text(),'US Dollar')]")
	WebElement USdollar;
	//ViewDetails
	@FindBy (id="expand-business-details")
	List<WebElement> listViewDetails;
	
	@FindBy (id="close-business-details")
	WebElement closeViewDetails;
	@FindBy (xpath="//button[contains(@id,'context-delete')]")
	List<WebElement> deleteButtonList;
	//view details - edit
	@FindBy (xpath="//a[contains(@id,'business-edit-btn')]")
	WebElement editButton;
	
	@FindBy (id="business-form-name")
	WebElement businessNameField;
	//dodavanjeNoveBankeUEditu
	@FindBy (id="business-form-add-bank-btn")
	WebElement addBank;
	@FindBy(id="bank-dialog-name")
	WebElement bankNameNew;
	@FindBy(id="bank-dialog-num")
	WebElement bankAccount;
	@FindBy (id="bank-dialog-swf-num")
	WebElement bankSwift;
	@FindBy (id="bank-dialog-pay-inst")
	WebElement bankPayment;
	@FindBy (xpath="//label[@for='bank-dialog-currency']")
	WebElement bankCurrency;
	@FindBy (xpath="//*[@id=\"app\"]/div[7]/div/div/div[2]/a/div/div")
	WebElement euroCurrency1;
	@FindBy (id="bank-dialog-add-bank")
	WebElement addBankSave;
	@FindBy (id="bank-list-bank-name")
	List<WebElement> namesBankList;
	//
	@FindBy (xpath ="//li[@class='v-expansion-panel__container primary white--text']")
	List<WebElement> bankList;
	
	@FindBy (xpath="//div[contains(text(),'Edit')]")
	WebElement editBank;
	
	@FindBy (id="bank-expanded-bank-name")
	WebElement bankNameEdit;
	@FindBy (xpath="//div[contains(text(),'Lock')]")
	WebElement LockBank;
	@FindBy (xpath="//div[contains(text(),'Yes')]")
	List<WebElement> ListYesButton;
	@FindBy (xpath="//*[@id='app']/div[10]/main/div/div/div[2]/div[2]/div/form/div[1]/div[2]/ul[1]/li/div[1]/div[2]/i")
	WebElement backTo;
	@FindBy (id="bank-list-bank-name")
	List<WebElement> listNameBank;
	@FindBy(id="business-form-save-btn")
	WebElement saveEdit;
	@FindBy (xpath="//div[@class='v-alert success']/div")
	WebElement saveEditVerify;
	
	@FindBy (xpath="//i[contains(text(), 'arrow_back')]")
	WebElement backToBusiness;
	
	@FindBy (id="navbar-logout")
	WebElement logOutMenu;
	@FindBy (id="navbar-logout-btn")
	WebElement logOut;
	@FindBy (id="logut-yes")
	WebElement logOutYes;
	public BusinessPage(WebDriver driver) {
		super(driver);
	}
	public void businessTab() {
		wait.until(ExpectedConditions.elementToBeClickable(navigateBusiness));
		navigateBusiness.click();
	}
	public String businessText() {
		return businessListText.getText();
	}
	public void ViewDetails() {
		listViewDetails.get(0).click();
		editButton.click();
		businessNameField.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Bambi");
		bankList.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(editBank));
		editBank.click();
		bankNameEdit.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Generali");
		LockBank.click();
		backTo.click();
	}
	public String nameOfBank() {
		return listNameBank.get(0).getText();
	}
	public String nameOFBusinnes() {
		return businessNameField.getAttribute("value");
	}
	public void addBank() {
		addBank.click();
		bankNameNew.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"SwissBank");
		bankAccount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"123-2345545-23");
		bankSwift.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"OAN");
		bankPayment.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"cash payment");
		bankCurrency.click();
		wait.until(ExpectedConditions.elementToBeClickable(euroCurrency1));
		euroCurrency1.click();
		addBankSave.click();
	}
	public String verifyAddBank() {
		return namesBankList.get(2).getText();
	}
	public void deleteBank() {
		namesBankList.get(2).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteButtonList.get(2)));
		deleteButtonList.get(2).click();
		wait.until(ExpectedConditions.elementToBeClickable(ListYesButton.get(0)));
		ListYesButton.get(0).click();
		backToBusiness.click();
	}
	public void save() {
		saveEdit.click();
		
	}
	public String verifySaveEdit() {
		return saveEditVerify.getText();
	}
	public void newBusiness() {
		addNewBusiness.click();
		businessNameField.sendKeys("Bulevar Zvezda");
		country.click();
		countryAndorra.click();
		city.sendKeys("Andorra");
		street.sendKeys("Andorra Street");
		zip.sendKeys("247898");
		registryNumber.sendKeys("25456");
		addBank.click();
		bankNameNew.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Bank1");
		bankAccount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"123-2344245-23");
		bankSwift.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"UAN");
		bankPayment.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"cash payment");
		bankCurrency.click();
		USdollar.click();
		addBankSave.click();
	}
	public String newBusinessBank() {
		return namesBankList.get(0).getText();
	}
	
	public String newBusinessVerify() {
		return businessName.get(businessName.size()-1).getText();
	}
	public void logOutBtn() {
		logOutMenu.click();
		logOut.click();
		logOutYes.click();
	}
	
}
