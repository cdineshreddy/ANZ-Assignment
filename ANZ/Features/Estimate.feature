Feature: Validate the Borrowing Calculator

Background: User navigate to the landing page
			Given User launch Chrome browser
			When User opens URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
			Then Page Title should be "Home loan borrowing power calculator | ANZ"

Scenario: Configure the Person details		
		And User select Application Type "Single"
		And User select Dependents 0
		And User select Property "Home to Live in"
		And User enter your Income 80000
		And User enter other Income 10000
		And User enter Living Expenses 500
		And User enter Current Home Loan Repayments 0
		And User enter Other Loan Repayments 100
		And User enter Other commitments 0
		And User enter Total Credit Card limits 10000
		And User click on submit button
		Then User should validate the Borrowing Estimate
		And Close the browser
		
Scenario: Click on the Start Over button to clear Form
		And User select Application Type "Single"
		And User select Dependents 0
		And User select Property "Home to Live in"
		And User enter your Income 80000
		And User enter other Income 10000
		And User enter Living Expenses 500
		And User enter Current Home Loan Repayments 0
		And User enter Other Loan Repayments 100
		And User enter Other commitments 0
		And User enter Total Credit Card limits 10000
		And User click on submit button
		And User click on Start Over button
		Then System should clear the form
		And Close the browser
		
Scenario: Verify the message when user provide only Living expenses
		And User enter Living Expenses 1
		And User click on submit button
		Then User should validate the message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator"
		And Close the browser