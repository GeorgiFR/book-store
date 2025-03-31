package com.example.book_store.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {

    @NotBlank
    String name;

    String description;

    @NotBlank
    String authorName;

    @Min(0)
    double price;
}
