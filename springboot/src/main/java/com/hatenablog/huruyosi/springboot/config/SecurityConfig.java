package com.hatenablog.huruyosi.springboot.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hatenablog.huruyosi.springboot.service.JdbcUserDetailsServiceImpl;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebMvcConfigurerAdapter  {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("SbAdmin2Controller/login");
	}

	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private DataSource dataSource;

		@Autowired
	    private JdbcUserDetailsServiceImpl userDetailsService;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests()
	            .antMatchers("/sbadmin2/**").permitAll()
	            .anyRequest().fullyAuthenticated()
	            .and()
	        .formLogin()
	        	.loginPage("/login")
                .usernameParameter("userid")
                .passwordParameter("password")
                .defaultSuccessUrl("/sbadmin2/index.html")
	        	.failureUrl("/login?error")
	        	.permitAll()
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll();
		}

	    @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService) ;
	    }

	}
}
