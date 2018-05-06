Feature: Check if new users can be registered

@Regression
Scenario Outline: Simple user registration
	Given User registered with details <firstName>, <lastName>, <phone>, <email>, <username> and <password>
	When User logged in after registration with <username> and <password> 
	Then Check if user details <firstName>, <lastName>, <phone>, <email>, <username> and <password> are properly stored in DB

	Examples:
		|firstName|lastName|phone     |email        |username|password|
		|Ravi     |Kalla   |1111111111|ravi@ravi.com|ravi    |ravi    |
		|Raj      |Kumar   |2222222222|raj@raj.com  |Raj     |Raj     |
		|Matt     |Damon   |3333333333|matt@matt.com|Matt    |Matt    |
