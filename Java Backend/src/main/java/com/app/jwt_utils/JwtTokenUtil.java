//package com.app.jwt_utils;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import java.util.Date;
//import java.util.function.Function;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtTokenUtil {
//	    @Value("${jwt.secret}")
//	    private String secret;
//
//	    @Value("${jwt.expiration}")
//	    private long expiration;
//
//	    public String generateToken(UserDetails userDetails) {
//	        return Jwts.builder()
//	                .setSubject(userDetails.getUsername())
//	                .setIssuedAt(new Date())
//	                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
//	                .signWith(SignatureAlgorithm.HS256, secret)
//	                .compact();
//	    }
//
//	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//	        final Claims claims = extractAllClaims(token);
//	        return claimsResolver.apply(claims);
//	    }
//
//	    private Claims extractAllClaims(String token) {
//	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//	    }
//
//	    public Boolean isTokenExpired(String token) {
//	        return extractExpiration(token).before(new Date());
//	    }
//
//	    public Date extractExpiration(String token) {
//	        return extractClaim(token, Claims::getExpiration);
//	    }
//
//	    public String extractUsername(String token) {
//	        return extractClaim(token, Claims::getSubject);
//	    }
//
//	    public Boolean validateToken(String token, UserDetails userDetails) {
//	        final String username = extractUsername(token);
//	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	    }
//	
//
//}