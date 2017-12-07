package in.ravikalla.cloudBank.config;

import java.security.SecureRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import in.ravikalla.cloudBank.service.UserServiceImpl.UserSecurityService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger L = LogManager.getLogger(SecurityConfig.class);

	private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**",
            "/signup",
            "/console/**" // Added for H2 DB URL while testing
    };

//    @Autowired
//    private Environment env;

    @Autowired
    private UserSecurityService userSecurityService;

    private static final String SALT = "salt"; // Salt should be protected carefully

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    		L.debug("53 : Start : SecurityConfig.configure(...)");
        http
                .authorizeRequests().
//                antMatchers("/**").
                antMatchers(PUBLIC_MATCHERS).
                permitAll().anyRequest().authenticated();

        http
                .csrf().disable().cors().disable()
                .formLogin().failureUrl("/index?error").defaultSuccessUrl("/userFront").loginPage("/index").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index?logout").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe();

        http.headers().frameOptions().disable(); // Added for H2 DB URL while testing 
//        L.debug("67 : End : SecurityConfig.configure(...)");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    		L.debug("72 : Start : SecurityConfig.configureGlobal(...)");
//    	 auth.inMemoryAuthentication().withUser("user").password("password").roles("USER"); //This is in-memory authentication
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
//        L.debug("75 : End : SecurityConfig.configureGlobal(...)");
    }
}
