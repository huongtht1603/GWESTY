Feature: As a Gwesty customer and admin, I should be able to login and logout with valid credentials

	@SmokeTest @RegressionTest
  Scenario: Login into the application as customer role with valid credentials and logout
  	Given I am on the url
    Then I click on login link and wait for sign in page
    Then I should see login Page
    When I enter username
    And I enter password
    And I check on Remember me
    And I click on Sign In button
    Then I am logged in with my account displayed on the top-right of page
    When I Click on log out
	  Then I got log out from the application and land on home page
   
   @SmokeTest @RegressionTest
  Scenario: Login into the application as admin role with valid credentials and logout
  	Given I am on the url
    Then I click on login link and wait for sign in page
    Then I should see login Page
    When I enter username of admin
    And I enter password of admin
    And I check on Remember me
    And I click on Sign In button
    Then I am logged in with my role "Admin" displayed on the top-right of page
    When I Click on log out
	  Then I got log out from the application and land on home page
		
    @SmokeTest @RegressionTest @Testing
  Scenario Outline: Login into the application with invalid credentials in these <cases>
    Given I am on the url
    Then I click on login link and wait for sign in page
    Then I should see login Page
    When enter "<username>"
    And enter "<password>" 
    And I click on Sign In button
    Then I see the "Error: Wrong username or password !!!" displayed

    Examples: 
      | cases                       | username   | password  |
      | Wrong username              | hoangny123 | 123456    |
      | Wrong password              | hoangny    | 12345678  |
      | Wrong username and password | hoangny123 | 12345678  |
