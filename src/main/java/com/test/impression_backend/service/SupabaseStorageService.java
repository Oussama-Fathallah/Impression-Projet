package com.test.impression_backend.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;



@Service
public class SupabaseStorageService {



    @Value("${supabase.url}")
    private String url;



    @Value("${supabase.key}")
    private String key;



    @Value("${supabase.bucket}")
    private String bucket;





    public String upload(
            MultipartFile file
    )
            throws Exception {



        String path =
                "documents/"
                        + System.currentTimeMillis()
                        + "-"
                        + file.getOriginalFilename();





        String uploadUrl =
                url
                        + "/storage/v1/object/"
                        + bucket
                        + "/"
                        + path;





        HttpHeaders headers =
                new HttpHeaders();



        headers.set(
                "Authorization",
                "Bearer " + key
        );


        headers.set(
                "apikey",
                key
        );



        headers.setContentType(
                MediaType.APPLICATION_PDF
        );





        HttpEntity<byte[]> request =
                new HttpEntity<>(
                        file.getBytes(),
                        headers
                );





        RestTemplate rest =
                new RestTemplate();




        rest.exchange(
                uploadUrl,
                HttpMethod.POST,
                request,
                String.class
        );






        return url
                + "/storage/v1/object/public/"
                + bucket
                + "/"
                + path;


    }



}