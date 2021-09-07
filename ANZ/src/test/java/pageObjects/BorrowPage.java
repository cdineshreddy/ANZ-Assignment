package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BorrowPage {
	
		public WebDriver driver;
		
		public BorrowPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//label[@for='application_type_single']")
		private WebElement btnApplicationType;
		
		@FindBy(xpath = "//select[@title='Number of dependants']")
		private WebElement dpdDependants;
		
		@FindBy(xpath = "//label[@for='borrow_type_home']")
		private WebElement btnProperty;
		
		@FindBy(xpath = "//input[@aria-labelledby='q2q1']")
		private WebElement txtYourIncome;
		
		@FindBy(xpath = "//input[@aria-labelledby='q2q2']")
		private WebElement txtOtherIncome;
		
		@FindBy(xpath = "//input[@aria-labelledby='q3q1']")
		private WebElement txtLivingExpenses;
		
		@FindBy(xpath = "//input[@aria-labelledby='q3q2']")
		private WebElement txtCurrentHomeLoanRepaymets;
		
		@FindBy(xpath = "//input[@aria-labelledby='q3q3']")
		private WebElement txtOtherLoanRepaymets;
		
		@FindBy(xpath = "//input[@aria-labelledby='q3q4']")
		private WebElement txtOtherCommitments;
		
		@FindBy(xpath = "//input[@aria-labelledby='q3q5']")
		private WebElement txtTotalCreditCardLimits;
		
		@FindBy(id = "btnBorrowCalculater")
		private WebElement btnBorrow;
		
		@FindBy(id ="borrowResultTextAmount")
		 private WebElement estimateAmount;
		
		@FindBy(xpath = "(//*[text()='Start over'])[1]")
		private WebElement lnkStartOver;
		
		@FindBy(css ="span.borrow__error__text")
		private WebElement lblErrorMsg;
		
		public void setApplicationType() {
			btnApplicationType.click();
		}
		
		public void setDependants(int number) {
			Select select = new Select(dpdDependants);
			select.selectByIndex(number);
		}
		
		public void setPropertyToBuy() {
			btnProperty.click();
		}
		
		public void setIncome(int amount) {
			txtYourIncome.click();
			String value = String.valueOf(amount); 
			txtYourIncome.sendKeys(value);
		}
		
		public void setOtherIncome(int amount) {
			txtOtherIncome.click();
			String value = String.valueOf(amount); 
			txtOtherIncome.sendKeys(value);
		}
		
		public void setLivingExpenses(int amount) {
			txtLivingExpenses.click();
			String value = String.valueOf(amount); 
			txtLivingExpenses.sendKeys(value);
		}
		
		public void setHomeLoanRepayments(int amount) {
			txtCurrentHomeLoanRepaymets.click();
			String value = String.valueOf(amount); 
			txtCurrentHomeLoanRepaymets.sendKeys(value);
		}
		
		public void setOtherLoanRepayments(int amount) {
			txtOtherLoanRepaymets.click();
			String value = String.valueOf(amount); 
			txtOtherLoanRepaymets.sendKeys(value);
		}
		
		public void setOtherCommitments(int amount) {
			txtOtherCommitments.click();
			String value = String.valueOf(amount); 
			txtOtherCommitments.sendKeys(value);
		}
		
		public void setTotalCreditCardLimit(int amount) {
			txtTotalCreditCardLimits.click();
			String value = String.valueOf(amount); 
			txtTotalCreditCardLimits.sendKeys(value);
		}
		
		public void submit() {
			btnBorrow.click();			
		}
		
		public int getEstimateAmount() {			
			String finalAmount = estimateAmount.getText().replaceAll("[$,]", "").trim();
			int amount = Integer.parseInt(finalAmount);
			return amount;			
		}
		
		public void clickStartOver() {
			lnkStartOver.click();
		}
		
		public void verifyStartOver() {
			 int count = driver.findElements(By.id("borrowResultTextAmount")).size();
			if(count==0)
				System.out.println("Form is cleared");
			else
				System.out.println("Form not cleared");
		}
		
		public String getErrorMsg() {
			String msg = lblErrorMsg.getText();
			return msg;
		}
		
		
}
