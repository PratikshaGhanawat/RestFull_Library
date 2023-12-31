package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  //consider controller class for BookController
@RequestMapping("/library") //endpoints
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook") 
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks()  {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> updatedBookOptional = bookService.updateBook(id, updatedBook);
        return updatedBookOptional.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}