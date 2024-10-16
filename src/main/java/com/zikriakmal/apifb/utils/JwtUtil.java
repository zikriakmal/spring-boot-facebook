package com.zikriakmal.apifb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zikriakmal.apifb.dto.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedHashMap;


@Component
public class JwtUtil {
    private static final String SECRET_KEY = "yourSecretKey";
    public static final long EXPIRATION_TIME = 86400000;

    public String generateToken(UserResponse userResponse) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .claim("user", userResponse)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static UserResponse extractSubject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        // Extract the "user" claim as a LinkedHashMap
        LinkedHashMap<String, Object> userMap = claims.get("user", LinkedHashMap.class);

        return convertLinkedHashMapToObject(userMap, UserResponse.class);
    }

    // Convert LinkedHashMap to a specified Java class using Jackson's ObjectMapper
    private static <T> T convertLinkedHashMapToObject(LinkedHashMap<String, Object> map, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(map, valueType);
    }
}
