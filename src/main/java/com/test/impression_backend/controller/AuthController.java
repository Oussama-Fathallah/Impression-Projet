package com.test.impression_backend.controller;


import com.test.impression_backend.dto.LoginRequest;
import com.test.impression_backend.dto.LoginResponse;
import com.test.impression_backend.service.AuthService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {


    private final AuthService service;


    public AuthController(AuthService service){

        this.service = service;

    }



    @PostMapping("/register")
    public String register(
            @RequestBody LoginRequest request
    ){


        service.register(
                request.email(),
                request.password()
        );


        return "created";

    }




    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ){

        try {

            String token =
                    service.login(
                            request.email(),
                            request.password()
                    );


            return ResponseEntity.ok(
                    new LoginResponse(token)
            );


        } catch(RuntimeException e){


            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());

        }

    }


}