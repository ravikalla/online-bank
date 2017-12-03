package in.ravikalla.cloudBank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
}
