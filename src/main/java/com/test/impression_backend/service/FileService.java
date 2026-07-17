package com.test.impression_backend.service;


import com.test.impression_backend.dto.DocumentResponse;
import com.test.impression_backend.entity.Document;
import com.test.impression_backend.entity.User;
import com.test.impression_backend.repository.DocumentRepository;
import com.test.impression_backend.repository.UserRepository;


import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


@Service
public class FileService {


    private final DocumentRepository documentRepository;

    private final UserRepository userRepository;

    private final SupabaseStorageService supabaseStorageService;



    public FileService(
            DocumentRepository documentRepository,
            UserRepository userRepository,
            SupabaseStorageService supabaseStorageService
    ) {

        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
        this.supabaseStorageService = supabaseStorageService;

    }





    public DocumentResponse upload(
            MultipartFile file,
            String email
    ) throws Exception {



        User user =
                userRepository.findByEmail(email)
                        .orElseThrow(
                                () -> new RuntimeException("User not found")
                        );



        // Calcul nombre pages PDF
        int pages =
                countPages(file);




        String fileUrl =
                supabaseStorageService.upload(file);




        Document document =
                new Document();



        document.setFileName(
                file.getOriginalFilename()
        );


        document.setFilePath(
                fileUrl
        );


        document.setPages(
                pages
        );


        document.setUser(
                user
        );



        document =
                documentRepository.save(document);





        return new DocumentResponse(

                document.getId(),

                document.getFileName(),

                document.getFilePath(),

                document.getPages()

        );


    }







    private int countPages(
            MultipartFile file
    ) throws Exception {


        try(
                InputStream input = file.getInputStream();

                RandomAccessReadBuffer buffer =
                        new RandomAccessReadBuffer(input);

                PDDocument document =
                        Loader.loadPDF(buffer)

        ){

            return document.getNumberOfPages();

        }

    }



}