package org.apptopia.waterwayfreightsystem.api.api.authentication.jwt;

import java.util.Date;

import org.apptopia.waterwayfreightsystem.api.api.authentication.account.MyUserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "loadtoken";
    private int jwtExpiration = 3600;
 
    public String generateJwtToken(Authentication authentication) {
        MyUserPrincipal userPrincipal = (MyUserPrincipal) authentication.getPrincipal();
 
        return Jwts.builder()
                    .setSubject((userPrincipal.getUsername()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
    }
    
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }
        catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        }
        catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        }
        catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        }
        catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        }
        catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        return false;
    }
    
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                      .setSigningKey(jwtSecret)
                      .parseClaimsJws(token)
                      .getBody().getSubject();
    }
}
