/**
 * 
 */
package dev.paie.configuration;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Guillaume
 *
 */
@Configuration
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {

		if (req.getCookies() != null) {
			Stream.of(req.getCookies()).filter(c -> c.getName().equals(TOKEN_COOKIE)).map(c -> c.getValue())
					.forEach(t -> {
						Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(t).getBody();
						String username = body.getSubject();
						List<String> roles = body.get("roles", List.class);
						List<SimpleGrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new)
								.collect(Collectors.toList());
						Authentication authentication = new UsernamePasswordAuthenticationToken(username, null,
								authorities);
						SecurityContextHolder.getContext().setAuthentication(authentication);

					});
		}
		chain.doFilter(req, resp);
	}

}
