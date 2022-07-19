

Feature: As a guest and as a customer, I should be able to search for available room, booking and make payment

  @SmokeTest @RegressionTest
  Scenario: Verify if guest can search for available room, then booking and make payment
    Given I am on booking hotel page
		When I enter Checkin and Checkout
		And I enter Adult and Children
		And I click Search button
		When I click into view details of any room displayed
		Then I see a booking form
		When I click on Book Now button after checking all information
		When I fill out data on Add your informations, tick on I agree with Terms and Conditions, and click on Summit button
		Then I am on Checkout page
		When I fill out credit card information and click paynow
		Then I see a  message for successfull booking as "Thank you! Your booking has been placed. We will contact you to confirm about the booking soon" and i got the booking  number
		

  @SmokeTest @RegressionTest
   Scenario: Verify if customer can search for available room, then booking and make payment
 		When I login as a customer
		When I enter Checkin and Checkout
		And I enter Adult and Children
		And I click Search button
		When I click into view details of any room displayed
		Then I see a booking form
		When I click on Book Now button after checking all information
		When I fill out data on Add your informations, tick on I agree with Terms and Conditions, and click on the Summit button
		Then I am on Checkout page
		When I fill out credit card information and click paynow
		Then I see a  message for successfull booking as "Thank you! Your booking has been placed. We will contact you to confirm about the booking soon" and i got the booking  number
		And I search if this booking number is successful booking