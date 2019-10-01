package in.ravikalla.cloudBank;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@ActiveProfiles("test")
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features"
        , tags = {"@Regression"}
        , glue={"in.ravikalla.cloudBank.stepdef"}
		, plugin = { "pretty", "html:target/cucumber/cucumber-html-report", "json:target/cucumber/cucumber.json",
				"junit:target/cucumber/cucumber.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:target/extent-report.html" })
public class BDDTest {
	private static final Logger L = LogManager.getLogger(BDDTest.class);

//	@ClassRule
//	public static HoverflyRule hoverflyRule = HoverflyRule.inCaptureOrSimulationMode("account.json",HoverflyConfig.configs().proxyLocalHost(true));
	//public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode(HoverflyConfig.configs().proxyLocalHost(true));
	//public static HoverflyRule hoverflyRule = HoverflyRule.inCaptureOrSimulationMode("account.json", HoverflyConfig.configs().proxyLocalHost(true));

//	@BeforeClass
//	public static void setUp() throws Exception {
//		L.info("49 : Start : BDDTest.setUp()");
//		BDDTest.hoverflyRule.inSimulationMode(dsl(
//				service(EXTERNAL_BANK_URL)
//				.get(startsWith(EXTERNAL_BANK_URL_DEPOSIT))
//					.willReturn(
//						success("deposit success", "text/plain"))
//				.get(startsWith(EXTERNAL_BANK_URL_WITHDRAW))
//					.willReturn(
//						success("withdraw success", "text/plain"))), HoverflyConfig.configs().proxyLocalHost(true));
//	}

	@AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}