/**
 * 
 */
package dev.paie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.paie.entites.InfosAuthentification;

/**
 * @author Guillaume
 *
 */
@RestController
public class AuthentificationController {

	@Value("${jwt.expires_in}")
	private Integer EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;

	@PostMapping(value = "/auth")
	public ResponseEntity<?> authentification(@RequestBody InfosAuthentification infos) {

		RestTemplate rt = new RestTemplate();
		return rt.postForEntity("https://guillaume-top-collegues.herokuapp.com/auth", infos, String.class);

	}

}
