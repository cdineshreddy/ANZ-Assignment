package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BorrowPage;

public class Steps {
	
	public WebDriver driver;
	public BorrowPage bp; 
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	    bp = new BorrowPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String pageTitle) throws Exception{
	   Assert.assertEquals(pageTitle, driver.getTitle());
	}

	@Then("User select Application Type {string}")
	public void user_select_application_type(String applicationType) throws Exception {
		bp.setApplicationType();
	}

	@Then("User select Dependents {int}")
	public void user_select_dependents(int dependant) throws Exception{
	   bp.setDependants(dependant);
	}

	@Then("User select Property {string}")
	public void user_select_property(String propertyType) throws Exception{
		bp.setPropertyToBuy();
	}

	@Then("User enter your Income {int}")
	public void user_enter_your_income(int amount) throws Exception{
	    	bp.setIncome(amount);
	}

	@Then("User enter other Income {int}")
	public void user_enter_other_income(int amount) throws Exception{
	    bp.setOtherIncome(amount);
	}

	@Then("User enter Living Expenses {int}")
	public void user_enter_living_expenses(int amount) throws Exception{
		bp.setLivingExpenses(amount);
	}

	@Then("User enter Current Home Loan Repayments {int}")
	public void user_enter_current_home_loan_repayments(int amount) throws Exception{
	    bp.setHomeLoanRepayments(amount);
	}

	@Then("User enter Other Loan Repayments {int}")
	public void user_enter_other_loan_repayments(int amount) throws Exception{
			bp.setOtherLoanRepayments(amount);
	}

	@Then("User enter Other commitments {int}")
	public void user_enter_other_commitments(int amount) throws Exception {
	    bp.setOtherCommitments(amount);
	}

	@Then("User enter Total Credit Card limits {int}")
	public void user_enter_total_credit_card_limits(int amount) throws Exception{
	    bp.setTotalCreditCardLimit(amount);
	}

	@Then("User click on submit button")
	public void user_click_on_submit_button() throws Exception{
	   bp.submit();
	}

	@Then("User should validate the Borrowing Estimate")
	public void user_should_validate_the_borrowing_estimate() throws Exception{
			int estimateAmount = bp.getEstimateAmount();
			if(estimateAmount==479000)
				System.out.println("Estimated amount is validated");
			else
				System.out.println("Estimated amount is not displaying properly");
	}

	@Then("Close the browser")
	public void close_the_browser() throws Exception {
	    driver.quit();
	}

	@Then("User click on Start Over button")
	public void user_click_on_start_over_button() throws Exception{
	    bp.clickStartOver();
	}

	@Then("System should clear the form")
	public void system_should_clear_the_form() throws Exception{
		bp.verifyStartOver();
	}

	@Then("User should validate the message {string}")
	public void user_should_validate_the_message(String message) throws Exception {
		String errorMsg = bp.getErrorMsg();
		Assert.assertTrue(errorMsg.contains(message));
	}

}
