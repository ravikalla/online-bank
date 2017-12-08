package in.ravikalla.cloudBank.stepdef;

import static in.ravikalla.cloudBank.util.AppConstants.URI_ACC;
import static in.ravikalla.cloudBank.util.AppConstants.URI_DEPOSIT;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.RestAssured;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import in.ravikalla.cloudBank.StartApplication;
import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.utils.TestUtils;
import in.ravikalla.cloudBank.utils.UserType;

import static in.ravikalla.cloudBank.util.AppConstants.*;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = { StartApplication.class }, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource("/application.yml")
public class UserRegistrationStep implements En {

	@Autowired
	WebApplicationContext context;

	MockMvc mockMvc;

	private static final Logger L = LogManager.getLogger(UserRegistrationStep.class);

	@Value("${local.server.port}")
	private int port;

	// Start : Global variables used while testing
	private UserType enumUserType = null;
	// End : Global variables used while testing

	@Before
	public void setup() throws IOException {
		L.debug("Start : UserRegistration.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;

		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		L.debug("End : UserRegistration.setUp()");
	}

	public UserRegistrationStep() {
		Then("^Register Users$", (DataTable objDataTable) -> {
			L.debug("Start : Register users");

			List<User> lstUsers = objDataTable.asList(User.class);
			lstUsers.forEach(objUser -> {
					L.debug("81 : User registration tests : " + objUser.getFirstName() + " : " + objUser.getLastName() + " : " + objUser.getEmail() + " : " + objUser.getPhone() + " : " + objUser.getUsername() + " : " + objUser.getPassword());
				try {
					String strUserJSON = TestUtils.objectToJson(objUser);
					mockMvc.perform(post(URI_USER + URI_USER_PROFILE).param("user", strUserJSON))
						.andExpect(status().is3xxRedirection());
				} catch (Exception e) {
					Assert.fail("87 : Couldnt Register the user : " + e);
				}
			});

			L.debug("End : Register users");
		});
	}
}
