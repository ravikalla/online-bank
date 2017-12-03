package in.ravikalla.cloudBank.stepdef;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@ContextConfiguration(classes = {
			StartApplication.class
		}
		, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource("/application.yml")
public class DepositCheckStep implements En {

    @Autowired
    WebApplicationContext context;
    
    MockMvc mockMvc;
  
	private static final Logger L = LogManager.getLogger(DepositCheckStep.class);

	@Value("${local.server.port}")
	private int port;

	@Before
	public void setup() throws IOException {
		L.debug("Start : DepositCheckStep.setUp()");

		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		L.debug("End : DepositCheckStep.setUp()");
	}

	public DepositCheckStep() {
		Given("^deposit amount$", () -> {
          L.info("Start : DepositCheckStep : calling deposit service ");
          try {
            mockMvc.perform(post("/account/deposit").param("amount", "10").param("accountType", "Primary").with(user("Admin").password("password"))).andExpect(status().is3xxRedirection());
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          L.info("End : DepositCheckStep : after calling deposit service");
        });
		
		Given("^withdraw amount$", () -> {
          L.info("Start : DepositCheckStep : calling withdraw service ");
          try {
            mockMvc.perform(post("/account/withdraw").param("amount", "10").param("accountType", "Primary").with(user("Admin").password("password"))).andExpect(status().is3xxRedirection());
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          L.info("End : DepositCheckStep : after calling withdraw service");
        });
	}
}
