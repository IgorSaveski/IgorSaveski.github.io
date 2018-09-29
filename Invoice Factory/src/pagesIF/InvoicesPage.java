package pagesIF;


import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class InvoicesPage extends PageObject {
	//Invoice page
	@FindBy (id="home-page-user")
	WebElement userName;
	
	@FindBy (css="h4[class='invoice-factory-header-title ml-3']")
	WebElement invoicesListText;
	
	@FindBy (xpath="//i[contains(text(),'library_add')]")
	WebElement addInvoice;
	
	//filter
	@FindBy (id="filter-reset")
	public
	WebElement refresh;
	
	
	//filterPeriod
	@FindBy (id="filter-period")
	WebElement period;
	@FindBy (id="this-month")
	WebElement thisMonth;
	@FindBy (id="last-month")
	WebElement lastMonth;
	@FindBy (id="reset-dates")
	WebElement resetDates;
	
	//status button in row of invoice
	@FindBy(xpath="//button[contains(@id,'inv-status-btn-')]")
	List<WebElement> status;
	@FindBy (xpath="//i[contains(text(),'arrow_drop_down')]")
	List<WebElement> statusDropdown;
	@FindBy (xpath="//div[contains(text(),'Paid')]")
	List<WebElement> statusPaid;
	@FindBy (xpath="//div[contains(text(),'YES')]")
	List<WebElement> changeStatusYes;
	@FindBy (xpath="//strong[contains(@id,'inv-status-2018-')]")
	List<WebElement> statusChangeText;
	
	//selectClient
	@FindBy (xpath="//label[contains(text(),'Select client')]")
	WebElement selectClient;
	@FindBy (xpath="//div[contains(text(),'Michel Owen')]")
	WebElement clientOwen;
	@FindBy (xpath="//div[contains(text(),'Igor Saveski')]")
	WebElement NoInvoiceClient;
	@FindBy (xpath="//div[@class='v-alert v-alert--outline primary--text']/div")
	WebElement noInvoicesMessage;
	//Date filter from
	@FindBy(id="filter-from")
	WebElement DateFrom;
	@FindBy (xpath ="//div[contains(text(),'30')]")
	WebElement DateFromDay;
	@FindBy (id="filter-from-ok")
	WebElement DateFromOK;
	@FindBy (id="filter-from-cancel")
	WebElement DateFromCancel;
	@FindBy (id="filter-from-any")
	WebElement DateFromAny;
	
	//Date filter to
	@FindBy (id="filter-to")
	WebElement DateTo;
	@FindBy (id="filter-to-cancel")
	WebElement DateToCancel;
	@FindBy (id="filter-to-any")
	WebElement DateToAny;
	@FindBy (id="filter-to-ok")
	WebElement DateToOK;
	@FindBy (xpath="//i[contains(text(),'chevron_right')]")
	WebElement DateToNextMonth;
	@FindBy (xpath ="//div[contains(text(),'13')]")
	WebElement DateToDay;
	
	//invoice option
	@FindBy(xpath="//i[contains(text(),'more_vert')]")
	List<WebElement> options;
	@FindBy(xpath="//button[contains(@id,'context-delete-')]")
	List<WebElement> optionDelete;	
	@FindBy(xpath="//a[contains(@id,'context-edit')]")
	List<WebElement> editOption;
	@FindBy (id="invoice-title-content")
	WebElement editTitle;
	@FindBy (id="inv-form-save-btn")
	WebElement editSave;
	@FindBy (xpath="//div[@class='v-alert success']/div")
	WebElement editSaveMessage;
	@FindBy(xpath="//a[contains(@href,'/invoices/preview/')]")
	List<WebElement>  previewOption;
	@FindBy (xpath="//a[@href='/invoices']")
	WebElement previewClose;
	@FindBy (xpath="//div[@class='v-toolbar__title']")
	WebElement previewVerify;
	@FindBy (xpath="//button[contains(@id,'context-download-dialog-yes')]")
	List<WebElement> deleteYes;
	@FindBy (xpath = "//strong[contains(@id,'inv-client')]")
	List<WebElement>	clientsInvoiceList;
	
	public InvoicesPage(WebDriver driver) {
		super(driver);
	}
	public String userNameText() {
		return userName.getText();
	}
	public void addInvoiceBtn() {
		wait.until(ExpectedConditions.visibilityOf(addInvoice));
		addInvoice.click();
	}
	public void refreshBtn() {
		refresh.click();
	}
	
	public void periodBtn() {
		period.click();
	}
	public void thisMonthBtn() {
		thisMonth.click();
	}
	public void lastMonthBtn() {
		lastMonth.click();
	}
	public String MonthFromVerify() {
		return DateFrom.getAttribute("value");
	}
	public String MonthToVerify() {
		return DateTo.getAttribute("value");
	}
	public void resetDatesBtn() {
		resetDates.click();
	}
	public void changeStatus() {
		status.get(0).click();
		statusDropdown.get(2).click();
		statusPaid.get(2).click();
		changeStatusYes.get(2).click();
	}
	public String changeStatusVerify() {
		wait.until(ExpectedConditions.visibilityOf(statusChangeText.get(0)));
		return statusChangeText.get(0).getText();
	}
	
	public void selectClientFilter() {
		wait.until(ExpectedConditions.visibilityOf(selectClient));
		selectClient.click();
		clientOwen.click();
	}
	public void selectClientFilterNoInvoice() {
		wait.until(ExpectedConditions.visibilityOf(selectClient));
		selectClient.click();
		NoInvoiceClient.click();
	}
	public String noInvoices() {
		return noInvoicesMessage.getText();
	}
	
	public void selectDateFrom() {
		DateFrom.click();
		DateFromCancel.click();
		DateFrom.click();
		DateFromAny.click();
		DateFrom.click();
		DateFromDay.click();
		DateFromOK.click();
	}
	public void selectDateTo() {
		DateTo.click();
		wait.until(ExpectedConditions.elementToBeClickable(DateToCancel));
		DateToCancel.click();
		DateTo.click();
		wait.until(ExpectedConditions.elementToBeClickable(DateToAny));
		DateToAny.click();
		wait.until(ExpectedConditions.elementToBeClickable(DateTo));
		DateTo.click();
		wait.until(ExpectedConditions.elementToBeClickable(DateToNextMonth));
		DateToNextMonth.click();
		wait.until(ExpectedConditions.elementToBeClickable(DateToDay));
		DateToDay.click();
		DateToOK.click();
	}
	public String invoiceListTitle() {
		wait.until(ExpectedConditions.visibilityOf(invoicesListText));
		return invoicesListText.getText();
	}
	public void optionPreview()   {
		options.get(0).click();
		previewOption.get(2).click();
	}
	public String optionPreviewVerify() {
		return previewVerify.getText();
	}
	public void closePreviewBtn() {
		previewClose.click();

	}
	public void optionEdit() {
		options.get(0).click();
		editOption.get(2).click();
		editTitle.click();
		editTitle.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"Faktura5");
		editSave.click();	
	}
	public String editSaveVerify() {
		return editSaveMessage.getText();
	}
	public void optionDelete() {
		options.get(1).click();
		optionDelete.get(1).click();
		deleteYes.get(1).click();
	}
	public int sizeOfClientsList() {
		return clientsInvoiceList.size();
	}
	public String verifyForSelectClient() {
		return clientsInvoiceList.get(0).getText();
	}

}
