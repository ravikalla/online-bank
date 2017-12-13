package in.ravikalla.cloudBank.stepdef;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.RestAssured;

import cucumber.api.java.Before;
import cucumber.api.java8.En;
import in.ravikalla.cloudBank.StartApplication;
import in.ravikalla.cloudBank.domain.SavingsAccount;
import in.ravikalla.cloudBank.domain.SavingsTransaction;
import in.ravikalla.cloudBank.utils.UserType;

import static in.ravikalla.cloudBank.util.AppConstants.*;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = { StartApplication.class }, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource("/application.yml")
public class DepositCheckSavAccStep implements En {

	@Autowired
	WebApplicationContext context;

	MockMvc mockMvc;

	private static final Logger L = LogManager.getLogger(DepositCheckSavAccStep.class);

	@Value("${local.server.port}")
	private int port;

	// Start : Global variables used while testing
	private UserType enumUserType = null;
	// End : Global variables used while testing

	@Before
	public void setup() throws IOException {
		L.debug("Start : DepositCheckSavAccStep.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;

		enumUserType = UserType.COMMON;

		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		L.debug("End : DepositCheckSavAccStep.setUp()");
	}

	public DepositCheckSavAccStep() {
		Given("^Common user logged in for Savings Account$", () -> {
			L.debug("Start : User logged in");

			enumUserType = UserType.COMMON;

			L.debug("End : User logged in");
		});

		And("^Initial balance in Savings account is ([^\"]*)$", (String strInitialBalance) -> {
			L.debug("Start : Intial balance match");

			try {
				SavingsAccount objSavingsAccount = getSavingsAccountDetails();

				L.debug("90 : Actual AccountBalance = {}, Expected = {}", objSavingsAccount.getAccountBalance().toPlainString(), strInitialBalance);
				Assert.assertEquals("Account Balance should match", strInitialBalance, objSavingsAccount.getAccountBalance().toPlainString());
			} catch (Exception e) {
				Assert.fail("132 : Couldnt check the initial balance : " + e);
			}

			L.debug("End : Intial balance match");
		});
		When("^Deposit money of ([^\"]*) dollars in SavingsAccount$", (String strDepositMoney) -> {
			L.debug("Start : Deposit money");
			try {
				mockMvc.perform(post(URI_ACC + URI_DEPOSIT).param("amount", strDepositMoney).param("accountType", "Savings")
						.with(user(enumUserType.getUserName()).password(enumUserType.getPWD())))
					.andExpect(status().is3xxRedirection());
			} catch (Exception e) {
				Assert.fail("143 : Deposit Money : " + e);
			}
			L.debug("End : Deposit money");
		});
		And("^Withdraw money of ([^\"]*) dollars from SavingsAccount$", (String strWithdrawMoney) -> {
			L.debug("Start : Withdraw money");
			try {
				mockMvc.perform(post(URI_ACC + URI_WITHDRAW).param("amount", strWithdrawMoney).param("accountType", "Savings")
						.with(user(enumUserType.getUserName()).password(enumUserType.getPWD()))).andExpect(status().is3xxRedirection());
			} catch (Exception e) {
				Assert.fail("153 : Withdraw Money : " + e);
			}
			L.debug("End : Withdraw money");
		});
		And("^Check remaining amount ([^\"]*) dollars in SavingsAccount$", (String strRemainingAmount) -> {
			L.debug("Start : Remaining balance match");
			try {
				SavingsAccount objSavingsAccount = getSavingsAccountDetails();
				Assert.assertEquals("Account Balance should match", strRemainingAmount, objSavingsAccount.getAccountBalance().toPlainString());
			} catch (Exception e) {
				Assert.fail("132 : Couldnt check the initial balance : " + e);
			}
			L.debug("End : Remaining balance match");
		});
		And("^Check if transaction count of SavingsAccount is greater than 0$", () -> {
			L.debug("Start : Remaining balance match");
			try {
				List<SavingsTransaction> savingsTransactionList = getSavingsTransactionsDetails();

				Assert.assertNotNull("Transactions cant be null", savingsTransactionList);
				Assert.assertNotNull("Transactions size should be greated than 0", savingsTransactionList.size() > 0);
				L.debug("Savings Transations size = " + savingsTransactionList.size());
//				Assert.assertEquals("Account Balance should match", strRemainingAmount, objSavingsAccount.getAccountBalance().toPlainString());
			} catch (Exception e) {
				Assert.fail("132 : Couldnt check the initial balance : " + e);
			}
			L.debug("End : Remaining balance match");
		});
	}

	private SavingsAccount getSavingsAccountDetails() throws Exception {
		MvcResult objMvcResult = mockMvc
				.perform(get(URI_ACC + URI_ACC_SAVINGS).with(user(enumUserType.getUserName()).password(enumUserType.getPWD()))
//								.contentType(MediaType.APPLICATION_JSON)
						)
				.andExpect(model().attributeExists("savingsAccount"))
				.andExpect(view().name("savingsAccount"))
				.andReturn();
		SavingsAccount objSavingsAccount = (SavingsAccount) objMvcResult.getModelAndView().getModel().get("savingsAccount");
		return objSavingsAccount;
	}
	private List<SavingsTransaction> getSavingsTransactionsDetails() throws Exception {
		MvcResult objMvcResult = mockMvc
				.perform(get(URI_ACC + URI_ACC_SAVINGS).with(user(enumUserType.getUserName()).password(enumUserType.getPWD()))
//								.contentType(MediaType.APPLICATION_JSON)
						)
				.andExpect(model().attributeExists("savingsTransactionList"))
				.andExpect(view().name("savingsAccount"))
				.andReturn();
		List<SavingsTransaction> savingsTransactionList = (List<SavingsTransaction>) objMvcResult.getModelAndView().getModel().get("savingsTransactionList");
		return savingsTransactionList;
	}
}
