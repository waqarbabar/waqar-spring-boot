package com.waqar.waqarspringboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginAccessDeniedHandler loginAccessDeniedHandler;

	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
//		auth.inMemoryAuthentication().withUser("user123").password("user123").roles("USER").and().withUser("admin123")
//				.password("{noop}admin123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
//		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/**").hasRole("USER").anyRequest()
//				.authenticated().and().formLogin().successHandler(loginSuccessHandler).loginPage("/index").permitAll()
//				.and().logout().invalidateHttpSession(true).clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("logout")).logoutSuccessUrl("/login?logout").permitAll()
//				.and().exceptionHandling().accessDeniedHandler(loginAccessDeniedHandler);

	}

}
