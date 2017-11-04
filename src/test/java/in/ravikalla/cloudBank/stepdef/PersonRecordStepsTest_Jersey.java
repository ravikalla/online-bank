package in.ravikalla.cloudBank.stepdef;

import java.io.IOException;
import java.util.ArrayList;
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

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

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

	private static final Logger L = LogManager.getLogger(PersonRecordStepsTest_Jersey.class);

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setup() throws IOException {
		L.debug("Start : PersonRecordStepsTest_Jersey.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;

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
	}
}
