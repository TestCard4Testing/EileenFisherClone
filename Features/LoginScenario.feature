Feature: Scenarios to log in

Background:
Given I open the application
Then I am on home page
And I accept all Cookies

@Login  
Scenario Outline: Logging in using valid credentials
When I click on the loginLink
When I log in using "<ValidCredentials>" in LoginPage
Then I see the myAccountLink

Examples:
|ValidCredentials|
|ValidCredentials|

