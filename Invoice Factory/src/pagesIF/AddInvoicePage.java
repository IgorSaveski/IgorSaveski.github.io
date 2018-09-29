package pagesIF;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class AddInvoicePage extends PageObject {
	@FindBy (id="inv-form-back-btn")
	WebElement back;
	
	@FindBy (id="inv-form-cancel-btn")
	WebElement cancel;
	
	@FindBy (xpath="//*[@id=\"app\"]/div[3]/div/div/div[2]/button[2]")
	WebElement cancelYes;
	@FindBy (xpath="//*[@id=\"app\"]/div[10]/main/div/div/div/div[3]/div/div")
	WebElement saveMessage;
	
	@FindBy (css= "v-card__title.headline.primary--text.text-xs-center")
	WebElement messageDiscard;
	@FindBy (xpath="//*[@id=\"app\"]/div[2]/div/div/div[2]/button[1]")
	WebElement discardNo;
	@FindBy (xpath="//*[@id=\"app\"]/div[2]/div/div/div[2]/button[2]")
	WebElement discardYes;
	
	@FindBy(id="click-to-enter")
	WebElement titleInvoice;
	
	@FindBy (css="p[class='body-2 my-0']")
	WebElement errorTitleEmpty;
	@FindBy (id="invoice-title-content")
	WebElement titleInvoiceInput;
	
		
	@FindBy (className="v-select__selections")
	List<WebElement> dropdown;
	
	@FindBy (xpath="//*[@id='app']/div[6]/div/div/div[2]/a/div/div")
	WebElement statusSent;
	
	@FindBy (xpath="//div[contains(text(),'Michel Owen')]")
	WebElement clientOwen;
	
	@FindBy (xpath="//div[contains(text(),'HappyJob')]")
	WebElement businessHappy;
	
	@FindBy (id="inv-form-basis")
	WebElement basis;
	
	@FindBy (xpath="//*[@id=\"app\"]/div[3]/div/div/div/a")
	WebElement euro;
	
	@FindBy (id="add-content-btn")
	WebElement addContent;
	
	@FindBy (id="inv-form-discount")
	WebElement discount;
	
	@FindBy (id="inv-form-tax")
	WebElement tax;
	
	@FindBy (css="label[for='inv-form-select-bank']")
	WebElement selectBank;
	
	@FindBy (xpath = "//*[@id='app']/div[2]/div/div/div[2]/a/div/div")
	WebElement komercialBank;
	
	@FindBy(id="inv-form-acc-num-value")
	WebElement komercialAccountNumber;
	
	@FindBy (id="inv-form-save-btn")
	WebElement saveInvoice;
	
	//addcontent
	@FindBy(name ="service0")
	WebElement service;
	
	@FindBy (name="note0")
	WebElement note;
	
	@FindBy (name="days0")
	WebElement days;
	
	@FindBy (name="hours0")
	WebElement hours;//sam pomnozi dane sa 8h-verifikovanje
	
	@FindBy (name="rate0")
	WebElement ratePerHour;
	
	@FindBy (name="amount")
	WebElement amount;//sam pomnozi rateperhour i hours
	
	@FindBy (id="context-delete-inv-content-delete-0")
	WebElement deleteContent;
	
	@FindBy (id="context-download-dialog-yes-inv-content-delete-0")
	WebElement deleteContentYes;
	
	@FindBy (id="context-download-dialog-no-inv-content-delete-0")
	WebElement deleteContentNo;
	
	@FindBy (id="inv-form-total")
	WebElement total; 
	
	@FindBy (id="inv-form-subtotal")
	WebElement subtotal;
	
	@FindBy (css="div[class='v-messages__message']")
	List<WebElement> errorListinvoice;
	@FindBy (className="v-messages__message")
	List<WebElement> errorList;
	public AddInvoicePage(WebDriver driver) {
		super(driver);
	}
	
	public void fillNewInvoice() {
		wait.until(ExpectedConditions.visibilityOf(titleInvoice));
		titleInvoice.click();
		titleInvoiceInput.sendKeys("Faktura1");
		dropdown.get(0).click();
		statusSent.click();
		dropdown.get(1).click();
		clientOwen.click();
		dropdown.get(2).click();
		businessHappy.click();
		dropdown.get(3).click();
		euro.click();
		basis.sendKeys("fact1");
		selectBank.click();
		komercialBank.click();
	}
	public void fillNewInvoiceError() {
		wait.until(ExpectedConditions.visibilityOf(titleInvoice));
		dropdown.get(0).click();
		statusSent.click();
		dropdown.get(1).click();
		clientOwen.click();
		dropdown.get(2).click();
		businessHappy.click();
		dropdown.get(3).click();
		euro.click();
		basis.sendKeys("fact1");
		selectBank.click();
		komercialBank.click();
	}
	public String errorTitleEM() {
		wait.until(ExpectedConditions.visibilityOf(errorTitleEmpty));
		return errorTitleEmpty.getText();
	}
	public void fillContent() {
		addContent.click();
		service.sendKeys("Servis1");
		note.sendKeys("cash payment");
		days.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"5");
		ratePerHour.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12.5");
		discount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"10");
		tax.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"20");
	}public void fillContentError() {
		addContent.click();
		service.sendKeys("Servis1");
		note.sendKeys("cash payment");
		days.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"sss");
		ratePerHour.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"ss");
		discount.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"ss");
		tax.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"ss");
	}
	public String errorDay() {
		return errorList.get(0).getText();
	}
	public String errorRate() {
		return errorList.get(1).getText();
	}
	public String errorDiscount() {
		return errorList.get(2).getText();

	}
	public String errorTax() {
		return errorList.get(3).getText();
	}
	public String errorSelectTo() {
		//wait.until(ExpectedConditions.visibilityOf())
		return errorListinvoice.get(0).getText();
	}
	public String errorSelectFrom() {
		return errorListinvoice.get(1).getText();
	}
	public String errorInvoiceNum() {
		return errorListinvoice.get(2).getText();
	}
	public String errorBasis() {
		return errorListinvoice.get(3).getText();
	}
	public String errorCurrency() {
		return errorListinvoice.get(4).getText();
	}
	public String errorBank() {
		return errorListinvoice.get(5).getText();
	}
	public void deleteContentNo() {
		deleteContent.click();
		deleteContentNo.click();
	}
	public boolean serviceForVerifyNoDelete() {
		return service.isDisplayed();
	}
	public void deleteContentYes() {
		wait.until(ExpectedConditions.visibilityOf(deleteContent));
		deleteContent.click();
		deleteContentYes.click();
	}
	public String subtotal() {
		return subtotal.getText();
	}
	public String total() {
		return total.getText();
	}
	public void save() {
		saveInvoice.click();
	}
	public String getSaveMessage() {
		return saveMessage.getText();
	}
	public void discardAddNewInvoiceNo() {
		wait.until(ExpectedConditions.visibilityOf(titleInvoice));
		titleInvoice.click();
		titleInvoiceInput.sendKeys("Faktura1");
		dropdown.get(0).click();
		statusSent.click();
		back.click();
		discardNo.click();	
	}
	public String verifyDiscardNo() {
		return titleInvoiceInput.getText();
	}
	public void discardAddNewInvoiceYes() {
		back.click();
		discardYes.click();
	}
	public void backBtn() {
		back.click();
	}
	public void cancelBtn() throws InterruptedException {
		cancel.click();
		Thread.sleep(3000);
		cancelYes.click();
		
	}
	

}
