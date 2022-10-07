package app.xquare.dms.global.security;

import app.xquare.dms.global.exception.UnAuthorizedException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class TokenProvider {
    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    @Value("${auth.jwt.secret}")
    private String secret;

    public String getToken() {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject("XQUARE_ADMIN")
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .setExpiration(new Date(System.currentTimeMillis() + 86400 * 1000))
                .compact();
    }

    public String getBearerToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.replace(TOKEN_PREFIX, "");
        }
        return null;
    }

    public Authentication authenticateUser(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
        } catch (Exception e) {
            throw UnAuthorizedException.EXCEPTION;
        }

        UserDetails userDetails = new AuthDetails();
        return new UsernamePasswordAuthenticationToken(userDetails, "", null);
    }
}
