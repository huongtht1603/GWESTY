

Feature: As a customer, I should be able to search for available room

   Scenario: Verify if customer can search for available room
 		When I log in as a customer
		When I enter checkin and checkout
		And I enter adult and children
		And I click a Search button
		Then I see displayed rooms in this page meet number of adult and children
