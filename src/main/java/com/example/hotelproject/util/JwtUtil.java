package com.example.hotelproject.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {
    public static String createToken(String userId, long expireTimeMs, String key) {
        Claims claims = Jwts.claims();
        claims.put("userId", userId);

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
            .signWith(SignatureAlgorithm.HS256, key)
            .compact();
    }
}