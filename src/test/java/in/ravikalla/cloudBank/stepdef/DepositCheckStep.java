package in.ravikalla.cloudBank.stepdef;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
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
import in.ravikalla.cloudBank.domain.PrimaryAccount;
import in.ravikalla.cloudBank.utils.UserType;

import static in.ravikalla.cloudBank.util.AppUtil.*;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = { StartApplication.class }, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource("/application.yml")
public class DepositCheckStep implements En {

	@Autowired
	WebApplicationContext context;

	MockMvc mockMvc;

	private static final Logger L = LogManager.getLogger(DepositCheckStep.class);

	@Value("${local.server.port}")
	private int port;

	// Start : Global variables used while testing
	private UserType enumUserType = null;
	// End : Global variables used while testing

	@Before
	public void setup() throws IOException {
		L.debug("Start : DepositCheckStep.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;

		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		L.debug("End : DepositCheckStep.setUp()");
	}

	public DepositCheckStep() {
//		Given("^deposit amount$", () -> {
//			L.info("Start : DepositCheckStep : calling deposit service ");
//			try {
//				mockMvc.perform(post(URI_ACC + URI_DEPOSIT).param("amount", "10").param("accountType", "Primary")
//					.with(user("Admin").password("password")))
//					.andExpect(status().is3xxRedirection());
//			} catch (Exception e) {
//				Assert.fail("74 : Deposit Amount");
//			}
//			L.info("End : DepositCheckStep : after calling deposit service");
//		});
//
//		Given("^withdraw amount$", () -> {
//			L.info("Start : DepositCheckStep : calling withdraw service ");
//			try {
//				mockMvc.perform(post(URI_ACC + URI_WITHDRAW).param("amount", "5").param("accountType", "Primary")
//						.with(user("Admin").password("password"))).andExpect(status().is3xxRedirection());
//			} catch (Exception e) {
//				Assert.fail("89 : Withdraw Amount");
//			}
//			L.info("End : DepositCheckStep : after calling withdraw service");
//		});
//
//		Then("^Check amount$", () -> {
//			L.debug("Start : Check Amount : calling check service");
//			try {
//				MvcResult objMvcResult = mockMvc
//						.perform(get(URI_ACC + URI_ACC_PRIMARY).with(user("Admin").password("password"))
//								.contentType(MediaType.APPLICATION_JSON))
//						.andExpect(model().attributeExists("primaryAccount"))
//						.andExpect(view().name("primaryAccount"))
////						.andDo(print())
//						.andReturn();
//				PrimaryAccount primaryAccount = (PrimaryAccount) objMvcResult.getModelAndView().getModel().get("primaryAccount");
//				Assert.assertEquals("Account Balance is matching", primaryAccount.getAccountBalance().toPlainString(), "5.00"); 
//			} catch (Exception e) {
//				Assert.fail("101 : Check Amount");
//			}
//			L.debug("End : Check Amount : calling check service");
//		});

		Given("^Common user logged in$", () -> {
			L.debug("Start : User logged in");
			enumUserType = UserType.COMMON;
			L.debug("End : User logged in");
		});
		And("^Initial balance in Checkins account is ([^\"]*)$", (String strInitialBalance) -> {
			L.debug("Start : Intial balance match");
			try {
				PrimaryAccount objPrimaryAccount = getPrimaryAccountDetails();
				Assert.assertEquals("Account Balance should match", strInitialBalance, objPrimaryAccount.getAccountBalance().toPlainString());
			} catch (Exception e) {
				Assert.fail("132 : Couldnt check the initial balance");
			}
			L.debug("End : Intial balance match");
		});
		When("^Deposit money of ([^\"]*) dollars$", (String strDepositMoney) -> {
			L.debug("Start : Deposit money");
			try {
				mockMvc.perform(post(URI_ACC + URI_DEPOSIT).param("amount", strDepositMoney).param("accountType", "Primary")
						.with(user(enumUserType.getUserName()).password(enumUserType.getPWD())))
					.andExpect(status().is3xxRedirection());
			} catch (Exception e) {
				Assert.fail("143 : Deposit Money");
			}
			L.debug("End : Deposit money");
		});
		And("^Withdraw money of ([^\"]*) dollars$", (String strWithdrawMoney) -> {
			L.debug("Start : Withdraw money");
			try {
				mockMvc.perform(post(URI_ACC + URI_WITHDRAW).param("amount", strWithdrawMoney).param("accountType", "Primary")
						.with(user(enumUserType.getUserName()).password(enumUserType.getPWD()))).andExpect(status().is3xxRedirection());
			} catch (Exception e) {
				Assert.fail("153 : Withdraw Money");
			}
			L.debug("End : Withdraw money");
		});
		And("^Check remaining amount ([^\"]*) dollars$", (String strRemainingAmount) -> {
			L.debug("Start : Remaining balance match");
			try {
				PrimaryAccount objPrimaryAccount = getPrimaryAccountDetails();
				Assert.assertEquals("Account Balance should match", strRemainingAmount, objPrimaryAccount.getAccountBalance().toPlainString());
			} catch (Exception e) {
				Assert.fail("132 : Couldnt check the initial balance");
			}
			L.debug("End : Remaining balance match");
		});
	}

	private PrimaryAccount getPrimaryAccountDetails() throws Exception {
		MvcResult objMvcResult = mockMvc
				.perform(get(URI_ACC + URI_ACC_PRIMARY).with(user(enumUserType.getUserName()).password(enumUserType.getPWD()))
//								.contentType(MediaType.APPLICATION_JSON)
						)
				.andExpect(model().attributeExists("primaryAccount"))
				.andExpect(view().name("primaryAccount"))
				.andReturn();
		PrimaryAccount primaryAccount = (PrimaryAccount) objMvcResult.getModelAndView().getModel().get("primaryAccount");
		return primaryAccount;
	}
}
