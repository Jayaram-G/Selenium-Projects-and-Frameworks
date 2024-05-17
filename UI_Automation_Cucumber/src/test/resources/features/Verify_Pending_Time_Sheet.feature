@timesheets
Feature: This feature is to get pending timesheet
Scenario: This test is to verify the pending timesheet
	Given the user is on the homepage
	And the user clicks on the time option
	And the user enter the name as "Peter Mac Anderson"
	And clicks the view button
	Then the user should see the message as "message"


