Feature: Check if money is deposited

@one
Scenario Outline: Check if the money is Deposite money can be withdrawn
	Given Common user logged in
	And Initial balance in Checkins account is <InitialBalance>
	When Deposit money of <DepositAmount> dollars
	And Withdraw money of <WithdrawAmount> dollars
	Then Check remaining amount <RemainingAmount> dollars

Examples:
	|InitialBalance|DepositAmount|WithdrawAmount|RemainingAmount|
	|1700.00       |1000   |500           |2200.00        |
	|2200.00       |1000000|0             |1002200.00      |

#Scenario Outline: Check if the money can be deposited
#Given XML for User "<FirstName>" and "<LastName>" is retrieved
#Then Validate if the XML response is matching with "<ExpectedJSONFileName>"
#
#Examples:
#	|FirstName|LastName|ExpectedXMLFileName|
#	|Ravi     |Kalla   |Response1.xml      |
#	|Raj      |Kumar   |Response2.xml      |
