package com.test.impression_backend.controller;

import com.test.impression_backend.dto.DocumentResponse;
import com.test.impression_backend.service.FileService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("*")
public class FileController {

    private final FileService service;

    public FileController(FileService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public DocumentResponse upload(
            @RequestParam("file") MultipartFile file,
            Principal principal
    ) throws Exception {

        return service.upload(
                file,
                principal.getName()
        );
    }

}