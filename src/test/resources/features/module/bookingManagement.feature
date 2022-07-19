
@tag
Feature: As a role of admin, I can search booking with booking number

    @SmokeTest @RegressionTest
  Scenario: Verify search function when providing valid booking number
    Given I login as an admin role
    When I click on Booking at the left panel
    And I click on By  booking number tab
    And I enter booking number as "7045-937000020"
    And I click on the Submit button
    Then I see search result a booking number as "7045-937000020" and customer name as "hoang lan"
    