package in.ravikalla.cloudBank.stepdef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;

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
public class PersonRecordStepsTest_Jersey_REST implements En {

	private static final Logger L = LogManager.getLogger(PersonRecordStepsTest_Jersey_REST.class);

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setup() throws IOException {
		L.debug("Start : PersonRecordStepsTest_Jersey_REST.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;

		L.debug("End : PersonRecordStepsTest_Jersey_REST.setUp()");
	}

	public PersonRecordStepsTest_Jersey_REST() {
		Given("^User inserted a person information in \"www.ravikalla.in\"$",
				(DataTable objDataTable) -> {
					L.debug("Start : PersonRecordStepsTest_Jersey_REST() : insert records in website");
					L.debug("End : PersonRecordStepsTest_Jersey_REST() : insert records in website");
				});
		Then("^Check if there are \"([^\"]*)\" users in \"www.ravikalla.in\"$",
				(String strUserCount) -> {
					L.debug("Start : PersonRecordStepsTest_Jersey_REST() : check user count in website for : " + strUserCount);
					L.debug("End : PersonRecordStepsTest_Jersey_REST() : check user count in website for : " + strUserCount);
				});

		Given("^Delete all persons from \"www.ravikalla.in\"$",
				() -> {
					L.info("Start : PersonRecordStepsTest_Jersey_REST() : delete all persons");
					L.info("End : PersonRecordStepsTest_Jersey_REST() : delete all persons");
				});
	}
}
