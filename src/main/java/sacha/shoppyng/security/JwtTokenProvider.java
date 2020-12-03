package sacha.shoppyng.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

/**
 * Provider du token jwt.
 */
@Component
public class JwtTokenProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    private String secretKey;

    @Value("${user.password.secret}")
    private String secret;

    /**
     * Key Initialization .
     */
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    /**
     * Creation of the token.
     * @param username
     * @return
     */
    public String createToken(String username) {

        Claims claims = Jwts.claims().setSubject(username);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * Retrieving authentication from the token
     * @param token
     * @return
     */
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    /**
     * Retrieving the user's name from the token.
     * @param token
     * @return
     */
    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Retrieving the token from the request
     * @param req
     * @return
     */
    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("authorization");
        if (bearerToken != null && bearerToken.toLowerCase().startsWith("bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
