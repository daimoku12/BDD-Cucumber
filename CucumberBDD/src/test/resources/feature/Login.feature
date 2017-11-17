Feature: CRM login test
  Verify CRM login page functionality
  
  Background: Testing use of background
  Then print test case started
  
  @SmokeTest
  Scenario: Test Login with valid credentials
    Given I am on CRM login page
    When I enter valid username and password and click on Login button
    Then I should successfully login
  
  @RegressionTest
  Scenario: Test Login with invalid credentials
    Given I am on CRM login page
    When I enter invalid username and invalid password and click on Login button
    Then I should not be able to login
  
  @RegressionTest
  Scenario: Test Login with valid credentials with parameters
    Given I am on CRM login page
    When I enter valid username as "kunalmalik12" and password as "test@123" and click on Login button
    Then I should successfully login
  
  @RegressionTest
  Scenario: Test Login with valid credentials using data table
    Given I am on CRM login page
    When I enter following for login
      | UserName   | Password |
      | kunalmalik | test@123 |
    Then I should successfully login
  
  @E2ETest
  Scenario Outline: Test Login with valid credentials using data set
    Given I am on CRM login page
    When I enter <Username> and <Password> for login
    Then I should successfully login

    Examples: 
      | Username   | Password |
      | kunalmalik | test@123 |
      | kunal      | test     |
