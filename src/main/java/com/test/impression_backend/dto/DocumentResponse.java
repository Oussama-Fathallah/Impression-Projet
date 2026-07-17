package com.test.impression_backend.dto;

public record DocumentResponse(

        Long id,
        String fileName,
        String filePath,
        Integer pages

) {
}