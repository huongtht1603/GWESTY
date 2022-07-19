
@tag
Feature: As a customer role, i can cancel booking 

  @SmokeTest @RegressionTest
  Scenario: Verify that users can cancel a booking if check-in date has not come yet
    Given i login into application with the role of customer
    When I navigate to My bookings tab
    When I click on cancel button of any room
    And I click on any reason for cancelation
    And I click on Cancel button on popup
    Then this booking is canceled successfully and the number of booking in My history is reduced by 1
