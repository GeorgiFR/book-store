package com.example.book_store.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Embeddable;

@Embeddable
public class Author {

    @NotBlank
    private String firstName;

    private String lastName;
}
