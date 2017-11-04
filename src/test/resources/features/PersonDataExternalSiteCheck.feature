Feature: Validate person information that is inserted to external site "www.ravikalla.in"

@RestVirtualization
Scenario: Insert and count records for REST flow
	Given User inserted a person information in "www.ravikalla.in"
		|FirstName|LastName|Profession|LocationX|LocationY|CompanyOrg      |CompanyHeadQuarters|
		|Ravi     |Kalla   |IT        |100      |150      |Capgemini USA   |Charlotte          |
		|Raj      |Kumar   |Auto      |200      |250      |Capgemini France|France             |
	Then Check if there are "2" users in "www.ravikalla.in"
