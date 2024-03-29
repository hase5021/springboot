package com.hatenablog.huruyosi.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hatenablog.huruyosi.springboot.service.JdbcUserDetailsServiceImpl;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled=true)
public class WebSecuirty extends WebSecurityConfigurerAdapter  {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcUserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/sbadmin2/css/**").permitAll()
				.antMatchers("/sbadmin2/js/**").permitAll()
				.antMatchers("/sbadmin2/bower_components/**").permitAll()
				.anyRequest().authenticated()
		.and().formLogin()
				.loginPage("/login")
				.usernameParameter("userid")
				.passwordParameter("password")
				.defaultSuccessUrl("/sbadmin2/index.html")
				.failureUrl("/login?error").permitAll()
		.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true).permitAll()
		.and().rememberMe()
				.tokenRepository(jdbcTokenRepository())
				.tokenValiditySeconds(604800) // remember for a week. ( 1 * 60 * 60 * 24 * 7 ) sec
		;
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	 /**
	  * Remember Me 認証に利用するトークンのリポジトリ
	 * @return
	 */
	@Bean
	public PersistentTokenRepository jdbcTokenRepository() {
		JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
		repository.setDataSource(dataSource);
//		repository.setCreateTableOnStartup(true);
		return repository;
	}
}
