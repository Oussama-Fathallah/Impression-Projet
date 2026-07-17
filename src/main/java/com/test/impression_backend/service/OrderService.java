package com.test.impression_backend.service;


import com.test.impression_backend.entity.Document;
import com.test.impression_backend.entity.Order;
import com.test.impression_backend.entity.User;
import com.test.impression_backend.repository.DocumentRepository;
import com.test.impression_backend.repository.OrderRepository;


import com.test.impression_backend.repository.UserRepository;
import org.springframework.stereotype.Service;



@Service
public class OrderService {


    private final OrderRepository repository;
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;


    public OrderService(
            OrderRepository repository,
            DocumentRepository documentRepository,
            UserRepository userRepository
    ){

        this.repository = repository;
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;

    }



    public Order create(Order order, String email){


        Document document =
                documentRepository.findById(order.getFileId())
                        .orElseThrow();


        User user =
                userRepository.findByEmail(email)
                        .orElseThrow();



        order.setDocument(document);

        order.setUser(user);



        return repository.save(order);

    }

}