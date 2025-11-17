package app.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtAdapter {
	private final SecretKey secretKey;
	private final long expirationMillis;

	public JwtAdapter(@Value("${security.jwt.secret}") String secretBase64,
					  @Value("${security.jwt.expirationMillis}") long expirationMillis) {
		byte[] decoded = Base64.getDecoder().decode(secretBase64);
		this.secretKey = Keys.hmacShaKeyFor(decoded);
		this.expirationMillis = expirationMillis;
	}

	public String generateToken(String username, List<String> roles) {
		long now = System.currentTimeMillis();
		return Jwts.builder()
				.setSubject(username)
				.claim("roles", roles)
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now + expirationMillis))
				.signWith(secretKey)
				.compact();
	}

	public Jws<Claims> parseToken(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token);
	}

	public SecretKey getSecretKey() { return secretKey; }
	public long getExpirationMillis() { return expirationMillis; }
}
