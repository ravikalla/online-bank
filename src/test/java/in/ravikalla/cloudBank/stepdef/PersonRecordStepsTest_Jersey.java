package in.ravikalla.cloudBank.stepdef;

<<<<<<< HEAD
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
>>>>>>> 15262ff7dafd987fba5b39c0dab751a48ab757e3
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
<<<<<<< HEAD
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.RestAssured;
=======

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
>>>>>>> 15262ff7dafd987fba5b39c0dab751a48ab757e3

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import in.ravikalla.cloudBank.StartApplication;

@ContextConfiguration(classes = {
			StartApplication.class
		}
		, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource("/application.yml")
public class PersonRecordStepsTest_Jersey implements En {

<<<<<<< HEAD
    @Autowired
    WebApplicationContext context;
    
    MockMvc mockMvc;
  
=======
>>>>>>> 15262ff7dafd987fba5b39c0dab751a48ab757e3
	private static final Logger L = LogManager.getLogger(PersonRecordStepsTest_Jersey.class);

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setup() throws IOException {
		L.debug("Start : PersonRecordStepsTest_Jersey.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;
<<<<<<< HEAD
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
=======

>>>>>>> 15262ff7dafd987fba5b39c0dab751a48ab757e3
		L.debug("End : PersonRecordStepsTest_Jersey.setUp()");
	}

	public PersonRecordStepsTest_Jersey() {
		Given("^Database has no persons for jersey flow$",
				() -> {
					L.debug("Start : PersonRecordStepsTest_Jersey() : insert records in DB");
					L.debug("End : PersonRecordStepsTest_Jersey() : insert records in DB");
				});
		And("^User inserted a person information for jersey flow$",
				(DataTable objDataTable) -> {
					L.debug("Start : PersonRecordStepsTest_Jersey() : insert records in db");
					L.debug("End : PersonRecordStepsTest_Jersey() : insert records in db");
				});
		Then("^Check if there are \"([^\"]*)\" users in the DB for jersey flow$",
				(String strUserCount) -> {
					L.info("Start : PersonRecordStepsTest_Jersey() : check user count in DB for : " + strUserCount);
					L.info("End : PersonRecordStepsTest_Jersey() : check user count in DB for : " + strUserCount);
				});

		Given("^Delete all persons from DB in Jersey flow$",
				() -> {
					L.info("Start : PersonRecordStepsTest_Jersey() : delete all persons");
					L.info("End : PersonRecordStepsTest_Jersey() : delete all persons");
				});
<<<<<<< HEAD
		
		Given("^get primary account details$", () -> {
		  L.info("Start : calling service ");
		  try {
            mockMvc.perform(get("/account/primaryAccount").with(user("Admin").password("password"))).andExpect(status().isOk());
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          L.info("End : after calling service");
		});
		
		Given("^get savings account details$", () -> {
          L.info("Start : calling get saving account service ");
          try {
            mockMvc.perform(get("/account/savingsAccount").with(user("Admin").password("password"))).andExpect(status().isOk());
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          L.info("End : get saving account service");
        });
		
		Given("^deposit amount$", () -> {
          L.info("Start : calling deposit service ");
          try {
            mockMvc.perform(post("/account/deposit").param("amount", "10").param("accountType", "Primary").with(user("Admin").password("password"))).andExpect(status().is3xxRedirection());
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          L.info("End : after calling deposit service");
        });
		
		Given("^withdraw amount$", () -> {
          L.info("Start : calling withdraw service ");
          try {
            mockMvc.perform(post("/account/withdraw").param("amount", "10").param("accountType", "Primary").with(user("Admin").password("password"))).andExpect(status().is3xxRedirection());
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          L.info("End : after calling withdraw service");
        });
=======
>>>>>>> 15262ff7dafd987fba5b39c0dab751a48ab757e3
	}
}
