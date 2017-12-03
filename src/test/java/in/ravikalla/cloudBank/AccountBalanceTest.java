package in.ravikalla.cloudBank;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
public class AccountBalanceTest {
 
  @Autowired
  WebApplicationContext context;
  
  MockMvc mockMvc;
  
  @Before
  public void setUp(){
    mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
  }
  
  @Test
  public void test() throws Exception{
    mockMvc.perform(get("/account/primaryAccount").with(user("admin").password("password"))).andExpect(status().isOk());
  }
}