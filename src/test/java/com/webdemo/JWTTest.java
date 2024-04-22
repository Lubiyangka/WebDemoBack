package com.webdemo;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {

    @Test
    public void testJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "dsfa");
        SecretKey key = Jwts.SIG.HS256.key().build();
        String token = Jwts.builder()
                .signWith(key)
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(token);
        Jws<Claims> claim = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
        System.out.println(claims);
    }

}
