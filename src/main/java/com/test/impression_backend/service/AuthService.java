package com.test.impression_backend.service;

import com.test.impression_backend.config.JwtService;
import com.test.impression_backend.entity.User;
import com.test.impression_backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {



    private final UserRepository repository;

    private final PasswordEncoder encoder;

    private final JwtService jwt;



    public AuthService(
            UserRepository repository,
            PasswordEncoder encoder,
            JwtService jwt
    ){

        this.repository=repository;
        this.encoder=encoder;
        this.jwt=jwt;

    }



    public void register(String email,String password){


        User user=new User();

        user.setEmail(email);

        user.setPassword(
                encoder.encode(password)
        );


        repository.save(user);


    }



    public String login(
            String email,
            String password
    ){

        User user =
                repository.findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Email incorrect"
                                )
                        );


        if(!encoder.matches(
                password,
                user.getPassword()
        )){

            throw new RuntimeException(
                    "Password incorrect"
            );

        }


        return jwt.generateToken(email);

    }



}
