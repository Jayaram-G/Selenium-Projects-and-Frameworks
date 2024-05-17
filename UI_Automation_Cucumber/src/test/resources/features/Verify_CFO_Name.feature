@GetCFOName
Feature: This feature is to get the CFO name from the OrangeHRM application
Scenario: This test is to verify the CFO name
	Given the user is logged in successfully and is on homepage
	When the user clicks on the Directory option from the Menu bar
	And the user selects the job title as "Chief Financial Officer" from the dropdown
	And clicks the search button
	Then the user should see the CFO name as "Peter Mac Anderson"


