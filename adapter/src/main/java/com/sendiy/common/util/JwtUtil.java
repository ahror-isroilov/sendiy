package com.sendiy.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * author: ahror
 * <p>
 * since: 8/28/24 5:12 PM
 */
@Component
public final class JwtUtil {
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("pBPLw8LG5cpXN1YJYwsPu9n9U3J7PIoj".getBytes());

    public static String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private static Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static String createAccessToken(String username, LocalDateTime expiration) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, expiration); // 1 hour
    }

    public static String createRefreshToken(String username, LocalDateTime expiration) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, expiration); // 7 days
    }

    private static String createToken(Map<String, Object> claims, String subject, LocalDateTime expiration) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(Date.from(expiration.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
