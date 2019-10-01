package in.ravikalla.cloudBank.stepdef;

import static in.ravikalla.cloudBank.util.AppConstants.HOME_SIGNUP;
import static in.ravikalla.cloudBank.util.AppConstants.URI_USER;
import static in.ravikalla.cloudBank.util.AppConstants.URI_USER_PROFILE;
import static in.ravikalla.cloudBank.util.AppConstants.URL_TEST_APP;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.ravikalla.cloudBank.domain.User;
import in.ravikalla.cloudBank.stepdef.SpringIntegrationTest.ResponseResultErrorHandler;
import in.ravikalla.cloudBank.utils.TestUtils;

public class StepDefsIntegrationTest extends SpringIntegrationTest {
	private static final Logger L = LogManager.getLogger(StepDefsIntegrationTest.class);

	// Start : Global variables used while testing
	private String username = null;
	private String password = null;
	// End : Global variables used while testing

	@When("^User logged in after registration with ([^\"]*) and ([^\"]*)$")
	public void userLoggedIn(String username, String password) throws Throwable {
		L.debug("Start : User logged in");
		this.username = username;
		this.password = password;
		L.debug("End : User logged in");
	}

	@Given("^User registered with details ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
	public void registerLogin(String firstName, String lastName, String phone, String email, String username, String password) throws Throwable {
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

	        final Map<String, String> headers = new HashMap<>();
	        headers.put("Accept", "application/json");
	        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
	        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

	        if (restTemplate == null) {
	            restTemplate = new RestTemplate();
	        }

	        restTemplate.setErrorHandler(errorHandler);
	        requestCallback.setBody(strUserJSON);
	        latestResponse = restTemplate
	          .execute(URL_TEST_APP + HOME_SIGNUP, HttpMethod.POST, requestCallback, response -> {
	              if (errorHandler.hadError) {
	                  return (errorHandler.getResults());
	              } else {
	                  return (new ResponseResults(response));
	              }
	          });
		} catch (Exception e) {
			Assert.fail("69 : Couldnt Register the user : " + e);
		}
	}

	@Then("^Check if user details ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*) are properly stored in DB$")
	public void checkInDBForCredentials(String firstName, String lastName, String phone, String email, String username, String password) throws Throwable {
		try {
	        final Map<String, String> headers = new HashMap<>();
	        headers.put("Accept", "application/json");
	        String plainCreds = username + ":" + password;
	        byte[] encodedAuth = Base64.encodeBase64( 
	        		plainCreds.getBytes(Charset.forName("US-ASCII")) );
	        String base64Creds = new String(encodedAuth);
	        headers.put("Authorization", "Basic " + base64Creds);
	        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
	        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

	        restTemplate.setErrorHandler(errorHandler);
	        latestResponse = restTemplate.execute(URL_TEST_APP + URI_USER + URI_USER_PROFILE, HttpMethod.GET, requestCallback, response -> {
	            if (errorHandler.hadError) {
	                return (errorHandler.getResults());
	            } else {
	                return (new ResponseResults(response));
	            }
	        });
	        L.debug("101 : latestResponse.getBody() = " + latestResponse.getBody());
	        User objUserFromDB = TestUtils.jsonToObject(latestResponse.getBody(), User.class);

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
	}
}