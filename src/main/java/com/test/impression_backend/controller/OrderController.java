package com.test.impression_backend.controller;


import com.test.impression_backend.entity.Order;
import com.test.impression_backend.service.OrderService;


import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {



    private final OrderService service;



    public OrderController(
            OrderService service
    ){

        this.service = service;

    }



    @PostMapping
    public Order create(
            @RequestBody Order order,
            Principal principal
    ){

        return service.create(
                order,
                principal.getName()
        );

    }


}