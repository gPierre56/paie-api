/**
 * 
 */
package dev.paie.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import dev.paie.dto.CollegueIdentifieDto;

/**
 * @author Guillaume
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JWTAuthorizationFilter jwtAuthorizationFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	RestTemplate rt = new RestTemplate();

	private final CollegueIdentifieDto CURRENT_USER = rt
			.getForObject("https://guillaume-top-collegues.herokuapp.com/auth/user", CollegueIdentifieDto.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/auth").permitAll()
				.antMatchers(HttpMethod.GET, "/bulletins/".concat(CURRENT_USER.getMatricule()))
				.hasAnyRole("ADMIN", "USER").antMatchers("/").hasRole("ADMIN").anyRequest().authenticated().and()
				.headers().frameOptions().disable().and()
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
