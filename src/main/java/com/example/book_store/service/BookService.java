package com.example.book_store.service;

import com.example.book_store.dto.request.BookRequest;
import com.example.book_store.dto.response.BookResponse;
import com.example.book_store.entity.BookEntity;
import com.example.book_store.mapper.BookMapper;
import com.example.book_store.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookResponse> getBooks() {
        List<BookEntity> books = bookRepository.findAll();

        return books.stream().map(book -> bookMapper.entityToResponse(book)).toList();
    }

    public BookResponse getBookById(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow();

        return bookMapper.entityToResponse(book);
    }

    @Transactional
    public BookResponse createBook(BookRequest bookRequest) {
        BookEntity book = bookMapper.requestToEntity(bookRequest);
        BookEntity createdBook = bookRepository.save(book);

        return bookMapper.entityToResponse(createdBook);
    }

    @Transactional
    public BookResponse updateBook(Long id, BookRequest bookRequest) {
        BookEntity book = bookRepository.findById(id).orElseThrow();
        bookMapper.updateEntityFromRequest(bookRequest, book);

        BookEntity savedBook = bookRepository.save(book);

        return bookMapper.entityToResponse(savedBook);
    }

    @Transactional
    public void deleteBook(Long id) {
        BookEntity book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
    }
}
