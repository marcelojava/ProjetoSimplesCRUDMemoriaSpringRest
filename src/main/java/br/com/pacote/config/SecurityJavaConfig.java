package br.com.pacote.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.pacote.componente.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@ComponentScan("br.com.pacote")
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint entryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("temporary").password("temporary").roles("ADMIN").
		and().withUser("user").password("userPass").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(entryPoint)
		.and()
		.authorizeRequests()
		.antMatchers("/user").authenticated()
		.and()
		.httpBasic();
	}
}
