package com.example.spring.test.spring.security.test1;

import java.security.AuthProvider;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;


@Configuration
//@EnableWebSecurity  
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	
	/*
	 *  This method is to login to spring security to access rest services with the user/password mentioned below.
	 *  This way is not recommended.
	 * 
	@Bean
	@Override
	
	protected UserDetailsService userDetailsService() {
		
		List<UserDetails> users= new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("vinay").password("12345").roles("USER").build());
		return new InMemoryUserDetailsManager(users);
		
	}	
	*/
	
	
	/*  Below method is for login to access rest services with the users exist in database.  
	
	@Bean
	public AuthenticationProvider AuthProvider() {
		
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());

		return provider;
	}
	
	
	
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        
         -------- This block is to allow login to h2 database if spring security is enabled. 
		httpSecurity.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        -------- This block is to allow login to h2 database if spring security is enabled. 
		
		httpSecurity
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();
    }
	
*/
	/*  This method is to enable OAuth 
	 * 
	 * .antMatchers("/").permitAll()
	 * 
	 * .authorizeRequests().antMatchers("/").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().disable();
	 * 
	 * */
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        
       // System.out.println(httpSecurity.);
		try {
			System.out.println("inside configure");
			httpSecurity
			.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated();
		}catch(Exception e) {
			System.err.println("exception caught:"+e);
		}	
				
    }
}
