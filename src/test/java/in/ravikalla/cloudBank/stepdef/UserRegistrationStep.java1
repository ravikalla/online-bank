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

import org.apache.commons.codec.language.bm.PhoneticEngine;
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

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import in.ravikalla.cloudBank.StartApplication;
import in.ravikalla.cloudBank.domain.SavingsAccount;
import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.util.AppConstants;
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
	private String username = null;
	private String password = null;
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
		Given("^User logged in after registration with ([^\"]*) and ([^\"]*)$",
				(String username, String password) -> {
			L.debug("Start : User logged in");
			this.username = username;
			this.password = password;

			L.debug("End : User logged in");
		});
		Then("^User registered with details ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$",
				(String firstName, String lastName, String phone, String email, String username, String password) -> {
			L.debug("Start : Register users");

			User objUser = new User();
			objUser.setFirstName(firstName);
			objUser.setLastName(lastName);
			objUser.setPhone(phone);
			objUser.setEmail(email);
			objUser.setUsername(username);
			objUser.setPassword(password);

			try {
				objUser.setEnabled(true);
				String strUserJSON = TestUtils.objectToJson(objUser);
				mockMvc.perform(post(HOME_SIGNUP)
						.content(strUserJSON)
//							.param("user", strUserJSON)
						.flashAttr("user", objUser)
//							.with(user(enumUserType.getUserName()).password(enumUserType.getPWD()))
//							.contentType(MediaType.APPLICATION_JSON)
						)
//							.andExpect(status().is3xxRedirection())
						;
			} catch (Exception e) {
				Assert.fail("87 : Couldnt Register the user : " + e);
			}

			L.debug("End : Register users");
		});
		Then("^Check if user details ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*) are properly stored in DB$",
				(String firstName, String lastName, String phone, String email, String username, String password) -> {
			L.debug("Start : Check users");

			try {
				MvcResult objMvcResult = mockMvc.perform(get(URI_USER + URI_USER_PROFILE)
						.with(user(username).password(password)))
					.andExpect(model().attributeExists("user"))
					.andReturn();
				User objUserFromDB = (User) objMvcResult.getModelAndView().getModel().get("user");

				Assert.assertNotNull("User shouldnt be null", objUserFromDB);
				Assert.assertNotNull("UserID shouldnt be null", objUserFromDB.getUserId());
				Assert.assertEquals("UserName should be same", username, objUserFromDB.getUsername());
				Assert.assertEquals("FirstName should be same", firstName, objUserFromDB.getFirstName());
				Assert.assertEquals("LastName should be same", lastName, objUserFromDB.getLastName());
				Assert.assertEquals("PhoneNumber should be same", phone, objUserFromDB.getPhone());
				Assert.assertEquals("Email should be same", email, objUserFromDB.getEmail());
			} catch (Exception e) {
				Assert.fail("129 : Couldnt Check the user : " + e);
			}

			L.debug("End : Check users");
		});
	}
}
