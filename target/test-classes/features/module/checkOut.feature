
@tag
Feature: As a role of admin, i check the "Total" is correctly calculated

  @SmokeTest @RegressionTest
  Scenario: Verify that the Total on the Booking Details page is correctly calculated  
    Given i login into application with the role of admin
     When I navigate to Booking at the left panel
    When I enter "Staying" to search field
    And I click on any room in Staying status
    Then I calculate fee and verify the Total at the end of the booking details page is correctly calculated 

