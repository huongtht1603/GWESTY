
@tag
Feature: on homepage, I can search my booking with booking number

  @SmokeTest @RegressionTest
  Scenario: Verify search function on homepage when entering valid booking number
    Given I am on the Url
    When I click on search button
    When enter "7045-937000020"
    When I click on the search button
    Then see information of "Id: 7045-937000020"
