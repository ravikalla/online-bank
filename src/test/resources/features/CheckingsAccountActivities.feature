Feature: Check money deposit and withdrawl from Checkings account

@Regression
Scenario Outline: Check if the money that is deposited money can be withdrawn from CheckingsAccount
	Given Common user logged in
	And Initial balance in Checkings account is <InitialBalance>
	When Deposit money of <DepositAmount> dollars in CheckingsAccount
	And Withdraw money of <WithdrawAmount> dollars from CheckingsAccount
	Then Check remaining amount <RemainingAmount> dollars in CheckingsAccount

	Examples:
		|InitialBalance|DepositAmount|WithdrawAmount|RemainingAmount|
		|1700.00       |1000         |500           |2200.00        |
		|2200.00       |1000000      |0             |1002200.00     |
		|1002200.00    |1000         |5000          |998200.00      |
		|998200.00     |0            |998200.00     |0.00           |
		|0.00          |0            |0.00          |0.01           |

@Regression
Scenario Outline: Check if overdraft is possible in CheckingsAccount
	Given Common user logged in
	And Initial balance in Checkings account is <InitialBalance>
	And Withdraw money of <WithdrawAmount> dollars from CheckingsAccount
	Then Check remaining amount <RemainingAmount> dollars in CheckingsAccount

	Examples:
		|InitialBalance|WithdrawAmount|RemainingAmount|
		|0.00          |500           |-500.00        |

@Regression
Scenario Outline: Check if lot of money can be deposited in CheckingsAccount
	Given Common user logged in
	And Initial balance in Checkings account is <InitialBalance>
	When Deposit money of <DepositAmount> dollars in CheckingsAccount
	Then Check remaining amount <RemainingAmount> dollars in CheckingsAccount
	And Withdraw money of <WithdrawAmount> dollars from CheckingsAccount

	Examples:
		|InitialBalance|DepositAmount   |RemainingAmount    |WithdrawAmount     |
		|-500.00       |1000            |500.00             |0.00               |
		|500.00        |1000000000000000|1000000000000500.00|1000000000000500.00|
