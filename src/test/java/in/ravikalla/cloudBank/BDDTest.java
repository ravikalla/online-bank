package in.ravikalla.cloudBank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import io.specto.hoverfly.junit.rule.HoverflyRule;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@ActiveProfiles("test")
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features"
        , tags = {"@one"}
        , glue={"in.ravikalla.cloudBank.stepdef"}
        , plugin = {"pretty" ,"html:target/cucumber/cucumber-html-report", "json:target/cucumber/cucumber.json" , "junit:target/cucumber/cucumber.xml"}
)
public class BDDTest {
  private static final Logger  L = LogManager.getLogger(BDDConfigurationTest.class);
        
  @ClassRule
  public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode();

  @BeforeClass
  public static void setUp() throws Exception {
        L.info("49 : Start : BDDTest.setUp()");
        BDDTest.hoverflyRule.inSimulationMode(dsl(
        	service("http://localhost:7001")
	        .get("/bofa/deposit")
	        .willReturn(
		success("success", "application/text"))));
  }
}
