package in.ravikalla.cloudBank;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import in.ravikalla.cloudBank.utils.TestUtils;
import io.specto.hoverfly.junit.rule.HoverflyRule;

import static in.ravikalla.cloudBank.utils.TestConstants.CONTENT_TYPE_APP_JSON;
import static in.ravikalla.cloudBank.utils.TestConstants.URI_BASE;
import static in.ravikalla.cloudBank.utils.TestConstants.URI_MONGO_GET_PERSONS;
import static in.ravikalla.cloudBank.utils.TestConstants.URI_MONGO_PUT_DELETEALL;
import static in.ravikalla.cloudBank.utils.TestConstants.URI_MONGO_SAVE_PERSON;
import static in.ravikalla.cloudBank.utils.TestConstants.URL_EXTERNAL_SITE;

/**
 * @author ravi kalla
 * @since 3-Nov-2017
 *
 */

@ActiveProfiles("test")
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features"
		, tags = {"@Regression, @RestVirtualization, ~@JulyRelease"}
		, glue={"in.ravikalla.cloudBank.stepdef"}
		, plugin = {"pretty" ,"html:target/cucumber/cucumber-html-report", "json:target/cucumber/cucumber.json" , "junit:target/cucumber/cucumber.xml"}
)

public class BDDConfigurationTest {
	private static final Logger L = LogManager.getLogger(BDDConfigurationTest.class);

	@ClassRule
	public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

	@BeforeClass
	public static void setup() throws Exception {
		L.debug("51 : Start : BDDConfigurationTest.setup()");
		BDDConfigurationTest.hoverflyRule.simulate(dsl(
				service(URL_EXTERNAL_SITE)
					.get(URI_BASE + URI_MONGO_GET_PERSONS)
						.willReturn(
								success(TestUtils.readFileFromDisk("src/test/resources/data/Response_AllPersons.json", Charset.defaultCharset()),
										CONTENT_TYPE_APP_JSON).withDelay(1, TimeUnit.SECONDS))
					.post(URI_BASE + URI_MONGO_SAVE_PERSON)
						.body(TestUtils.readFileFromDisk("src/test/resources/data/Input_Persons1.json", Charset.defaultCharset()))
						.willReturn(
								success(TestUtils.readFileFromDisk("src/test/resources/data/Response_Persons1.json", Charset.defaultCharset()),
										CONTENT_TYPE_APP_JSON))
					.post(URI_BASE + URI_MONGO_SAVE_PERSON)
						.body(TestUtils.readFileFromDisk("src/test/resources/data/Input_Persons2.json", Charset.defaultCharset()))
						.willReturn(
								success(TestUtils.readFileFromDisk("src/test/resources/data/Response_Persons2.json", Charset.defaultCharset()),
										CONTENT_TYPE_APP_JSON))						
					.get(URI_BASE + URI_MONGO_PUT_DELETEALL)
						.willReturn(success())

					.andDelay(1, TimeUnit.SECONDS).forMethod("POST")
				));
		L.debug("73 : End : BDDConfigurationTest.setup()");
	}
}
