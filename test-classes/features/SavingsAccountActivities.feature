Feature: Check of money deposited can be withdrawn from Savings account in all possible cases

@Regression
Scenario Outline: Check if the money that is deposited money can be withdrawn from SavingsAccount in general cases
	Given Common user logged in for Savings Account
	And Initial balance in Savings account is <InitialBalance>
	When Deposit money of <DepositAmount> dollars in SavingsAccount
	And Withdraw money of <WithdrawAmount> dollars from SavingsAccount
	Then Check remaining amount <RemainingAmount> dollars in SavingsAccount

	Examples:
		|InitialBalance|DepositAmount|WithdrawAmount|RemainingAmount|
		|4250.00       |1000         |500           |4750.00        |
		|4750.00       |1000000      |0             |1004750.00     |
		|1004750.00    |1000         |5000          |1000750.00     |
		|1000750.00    |0            |1000750.00    |0.00           |

@Regression
Scenario Outline: Check if overdraft is possible in SavingsAccount
	Given Common user logged in for Savings Account
	And Initial balance in Savings account is <InitialBalance>
	And Withdraw money of <WithdrawAmount> dollars from SavingsAccount
	Then Check remaining amount <RemainingAmount> dollars in SavingsAccount

	Examples:
		|InitialBalance|WithdrawAmount|RemainingAmount|
		|0.00          |500           |-500.00        |

@Regression
Scenario Outline: Check if large amounts of money can be deposited in SavingsAccount
	Given Common user logged in for Savings Account
	And Initial balance in Savings account is <InitialBalance>
	When Deposit money of <DepositAmount> dollars in SavingsAccount
	Then Check remaining amount <RemainingAmount> dollars in SavingsAccount
	And Check if transaction count of SavingsAccount is greater than 0
	And Withdraw money of <WithdrawAmount> dollars from SavingsAccount

	Examples:
		|InitialBalance|DepositAmount   |RemainingAmount    |WithdrawAmount     |
		|-500.00       |1000            |500.00             |0.00               |
		|500.00        |1000000000000000|1000000000000500.00|1000000000000500.00|
