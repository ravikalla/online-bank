Feature: Validate person information that is inserted in DB

@Regression
Scenario: Check if person details are deleted in DB for jersey flow
	Given Delete all persons from DB in Jersey flow
	Then Check if there are "0" users in the DB for jersey flow

@Regression
Scenario: Insert and count records for jersey flow
	Given Database has no persons for jersey flow
	And User inserted a person information for jersey flow
		|FirstName|LastName|Profession|LocationX|LocationY|CompanyOrg      |CompanyHeadQuarters|
		|Ravi     |Kalla   |IT        |100      |150      |Capgemini USA   |Charlotte          |
		|Raj      |Kumar   |Auto      |200      |250      |Capgemini France|France             |
	Then Check if there are "2" users in the DB for jersey flow

@JulyRelease
Scenario Outline: Validate the person records in XML format
	Given XML for User "<FirstName>" and "<LastName>" is retrieved
	Then Validate if the XML response is matching with "<ExpectedJSONFileName>"

	Examples:
		|FirstName|LastName|ExpectedXMLFileName|
		|Ravi     |Kalla   |Response1.xml      |
		|Raj      |Kumar   |Response2.xml      |

@JulyRelease
Scenario Outline: Validate the person records in JSON format
	Given JSON for User "<FirstName>" and "<LastName>" is retrieved
	Then Validate if the JSON response is matching with "<ExpectedJSONFileName>"

	Examples:
		|FirstName|LastName|ExpectedXMLFileName|
		|Ravi     |Kalla   |Response1.json     |
		|Raj      |Kumar   |Response2.json     |
