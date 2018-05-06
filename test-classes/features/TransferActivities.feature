Feature: Check account transfer activities between own accounts

@Regression
Scenario Outline: Check if the money can be transferred from Checkings account to Savings account
	Given Common user logged in for account transfer
	And Initial balance in Savings account is <InitialSavingsBalance>
	And Initial balance in Checkings account is <InitialCheckingsBalance>
	When Deposit money of <SavingsDeposit> dollars in SavingsAccount
	And Transfer money of <TransferAmount> from Savings to Checkings account
	Then Check remaining amount <RemainingSavingsBalance> dollars in SavingsAccount
	And Check remaining amount <RemainingCheckingsBalance> dollars in CheckingsAccount

	Examples:
		|InitialSavingsBalance|InitialCheckingsBalance|SavingsDeposit|TransferAmount|RemainingSavingsBalance|RemainingCheckingsBalance|
		|0.00                 |0.00                   |1000           |500          |500.00                 |500.00                     |
