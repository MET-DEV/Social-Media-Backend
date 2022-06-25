package com.metsoft.erpapp.security.auth;



import com.metsoft.erpapp.repository.UserRepository;
import com.metsoft.erpapp.service.responseModel.TokenResponse;
import io.jsonwebtoken.*;


import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TokenManager {

    @Autowired
    UserRepository userRepository;

    private static final int expirationTime = 5 * 60 * 1000;
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public TokenResponse generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        String token= Jwts.builder()
                .setSubject(authentication.getName())
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .setIssuer("Met")
                .claim("roles",authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(key)
                .compact();

        String refreshToken= Jwts.builder()
                .setSubject(authentication.getName())
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .setIssuer("Met")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(key)
                .compact();
        return new TokenResponse(token,refreshToken);
    }


    public boolean tokenValidate(String token) {
        if (checkExpirationTime(token) && getUsernameFromToken(token) != null) {
            return true;
        }
        return false;
    }


    UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(key);

        final Jws claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = (Claims) claimsJws.getBody();

        final Collection authorities =
                Arrays.stream(claims.get("roles").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        System.out.println(authorities);

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    public String getUsernameFromToken(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean checkExpirationTime(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }


    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
