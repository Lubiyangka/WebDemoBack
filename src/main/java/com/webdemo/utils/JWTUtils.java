package com.webdemo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtils {
    //token有效时长:毫秒
    private static final long EXPIRE = 7 * 24 * 60 * 60 * 1000;
    //token的密钥
    @Getter
    private static final String header = "Authorization";
    //token算法
    private static final SecretKey key = Jwts.SIG.HS256.key().build();

    public static String generateToken(String username) throws JwtException {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE);
        return Jwts.builder()
                .expiration(expireDate)
                .subject(username)
                .signWith(key)
                .compact();
    }

    public static Claims parseJWT(String jwt) throws JwtException {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

}

