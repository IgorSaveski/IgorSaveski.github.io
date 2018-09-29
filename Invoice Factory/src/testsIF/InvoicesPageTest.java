package testsIF;

import org.testng.Assert;
import org.testng.annotations.Test;

import pagesIF.AddInvoicePage;
import pagesIF.InvoicesPage;
import pagesIF.LoginPage;

public class InvoicesPageTest extends InitTest {
	LoginPage login;
	InvoicesPage invoices;
	AddInvoicePage addNew;

	@Test(priority = 9)
	public void discardNewInvoice() {
		// discardNoYes
		login = new LoginPage(driver);
		invoices.addInvoiceBtn();
		addNew.discardAddNewInvoiceNo();
		Assert.assertEquals(addNew.verifyDiscardNo(), "Faktura1");
		addNew.discardAddNewInvoiceYes();
		Assert.assertEquals(invoices.invoiceListTitle(), "Invoices List");
	}

	@Test(priority = 10)
	// Add new invoice,verify math operations and delete/not delete invoice contents
	public void addNewInvoice() {
		invoices = new InvoicesPage(driver);
		addNew = new AddInvoicePage(driver);
		invoices.addInvoiceBtn();
		addNew.fillNewInvoice();
		addNew.fillContent();
		addNew.deleteContentNo();
		Assert.assertTrue(addNew.serviceForVerifyNoDelete());
		Assert.assertEquals(addNew.subtotal(), "500.00");
		Assert.assertEquals(addNew.total(), "540.00");
		addNew.deleteContentYes();
		Assert.assertEquals(addNew.subtotal(), "0.00");
		addNew.fillContent();
		addNew.save();
		Assert.assertEquals(addNew.getSaveMessage(), "Invoice is successfully saved.");
	}

	@Test(priority = 11)
	// Test for all Error messages in add new invoice
	public void addNewInvoiceErrorMessages() {
		invoices = new InvoicesPage(driver);
		addNew = new AddInvoicePage(driver);
		invoices.addInvoiceBtn();
		addNew.save();
		Assert.assertEquals(addNew.errorSelectTo(), "The client field is required.");
		Assert.assertEquals(addNew.errorSelectFrom(), "The business field is required.");
		Assert.assertEquals(addNew.errorInvoiceNum(), "The Invoice number field is required.");
		Assert.assertEquals(addNew.errorBasis(), "The Basis field is required.");
		Assert.assertEquals(addNew.errorCurrency(), "The currency field is required.");
		Assert.assertEquals(addNew.errorBank(), "The bank field is required.");
		addNew.backBtn();
	}

	@Test(priority = 12)
	// Test for all Error messages in add new invoice contents
	public void addNewInvoiceErrorMessages1() throws InterruptedException {
		invoices = new InvoicesPage(driver);
		addNew = new AddInvoicePage(driver);
		invoices.addInvoiceBtn();
		// greske u popunjavanju invoice contenta
		addNew.fillNewInvoiceError();
		addNew.fillContentError();
		Assert.assertEquals(addNew.errorDay(), "The days field must be numeric and may contain decimal points.");
		Assert.assertEquals(addNew.errorRate(), "The rate field must be numeric and may contain decimal points.");
		Assert.assertEquals(addNew.errorDiscount(), "The discount field must be 0 or more.");
		Assert.assertEquals(addNew.errorTax(), "The tax field must be 0 or more.");
		Assert.assertEquals(addNew.subtotal(), "NaN");
		Assert.assertEquals(addNew.total(), "NaN");
		addNew.cancelBtn();
	}

	@Test(priority = 13)
	public void invoicesFilter() {
		//Filteri Client,Date,refresh,period
		invoices.selectClientFilterNoInvoice();
		Assert.assertEquals(invoices.noInvoices(), "There are no invoices!");
		invoices.selectClientFilter();
		Assert.assertEquals(invoices. verifyForSelectClient(), "Michel Owen");
		invoices.selectDateFrom();
		invoices.selectDateTo();
		invoices.refreshBtn();
		invoices.periodBtn();
		invoices.thisMonthBtn();
		Assert.assertEquals(invoices.MonthFromVerify(), "2018-08-01");
		Assert.assertEquals(invoices.MonthToVerify(), "2018-08-31");
		invoices.periodBtn();
		invoices.lastMonthBtn();
		Assert.assertEquals(invoices.MonthFromVerify(), "2018-07-01");
		Assert.assertEquals(invoices.MonthToVerify(), "2018-07-31");
		invoices.periodBtn();
		invoices.resetDatesBtn();
	}
	
	@Test(priority = 14)
	public void StatusChange() throws InterruptedException {
		//Promena statusa fakture
		Thread.sleep(2000);
		invoices.changeStatus();
		Assert.assertEquals(invoices.changeStatusVerify(),"Paid");
		
	}
	@Test(priority = 15)
	//Sve opcije u fakturama
	public void invoicesOption()  {
		invoices = new InvoicesPage(driver);
		invoices.optionPreview();
		Assert.assertEquals(invoices.optionPreviewVerify(), "Preview Invoice");
		invoices.closePreviewBtn();
		invoices.optionEdit();
		Assert.assertEquals(invoices.editSaveVerify(), "Invoice is successfully saved.");
		invoices.optionDelete();
		Assert.assertEquals(invoices.sizeOfClientsList(), 2 );
	}

}
