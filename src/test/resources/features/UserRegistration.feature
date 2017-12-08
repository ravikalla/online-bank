Feature: Check if user registration is working fine

@Regression
Scenario: Simple user registration
	Given Register Users
		|firstName|lastName|phone     |email        |username|password|
		|Ravi     |Kalla   |1111111111|ravi@ravi.com|ravi    |ravi    |
