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

import static in.ravikalla.cloudBank.util.AppConstants.*;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = { StartApplication.class }, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource("/application.yml")
public class TransferActivitiesStep implements En {

	@Autowired
	WebApplicationContext context;

	MockMvc mockMvc;

	private static final Logger L = LogManager.getLogger(TransferActivitiesStep.class);

	@Value("${local.server.port}")
	private int port;

	// Start : Global variables used while testing
	private UserType enumUserType = null;
	// End : Global variables used while testing

	@Before
	public void setup() throws IOException {
		L.debug("Start : TransferActivitiesStep.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;

		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		L.debug("End : TransferActivitiesStep.setUp()");
	}

	public TransferActivitiesStep() {

		Given("^Common user logged in for account transfer$", () -> {
			L.debug("Start : User logged in");

			enumUserType = UserType.COMMON;

			L.debug("End : User logged in");
		});
		When("^Transfer money of ([^\"]*) from Savings to Checkings account$", (String strTransferAmount) -> {
			L.debug("Start : Amount transfer from Savings to Checkings");
			try {
				mockMvc
						.perform(post(URI_TRANSFER + URI_TRANSFER_BETWEEN_ACCOUNTS)
								.with(user(enumUserType.getUserName()).password(enumUserType.getPWD()))
								.param("transferFrom", "Savings")
								.param("transferTo", "Primary")
								.param("amount", strTransferAmount)
								)
						.andExpect(status().is3xxRedirection());
			} catch (Exception e) {
				Assert.fail("132 : Couldnt transfer money from Savings to Checkings account : " + e);
			}
			L.debug("End : Amount transfer from Savings to Checkings");
		});
	}
}
