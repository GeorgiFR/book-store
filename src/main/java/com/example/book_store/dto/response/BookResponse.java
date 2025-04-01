package com.example.book_store.dto.response;

import lombok.Data;

@Data
public class BookResponse {

    Long id;

    String name;

    String description;

    String authorName;

    double price;
}
