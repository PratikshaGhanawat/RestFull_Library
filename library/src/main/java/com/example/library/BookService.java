package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
//inject instance of book repository into book service class
    @Autowired 
    private BookRepository repository;

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return repository.findById(id)
                .map(existingBook -> {
                    existingBook.setBookName(updatedBook.getBookName());
                    existingBook.setAuthor(updatedBook.getAuthor());
                    existingBook.setQuantity(updatedBook.getQuantity());
                    return repository.save(existingBook);
                });
    }

    public boolean deleteBook(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}