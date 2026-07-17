package com.test.impression_backend.config;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;


import java.util.Date;


@Service
public class JwtService {



    private final String SECRET =
            "12345678901234567890123456789012345678901234567890";


    public String generateToken(String email){


        return Jwts.builder()

                .subject(email)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()+86400000
                        ))

                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()
                        ))

                .compact();

    }



    public String extractEmail(String token){


        return Jwts.parser()

                .verifyWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()
                        ))

                .build()

                .parseSignedClaims(token)

                .getPayload()

                .getSubject();

    }



}