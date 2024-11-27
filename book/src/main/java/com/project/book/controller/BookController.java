package com.project.book.controller;
import com.project.book.model.Books;
import com.project.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/read")
    public List<Books> readBooks(@RequestParam String token){

        return bookService.viewBooks(token);
    }
    @PostMapping("/create")
    public List<Books> createBooks(@RequestBody List<Books> booksList
            , @RequestParam String token){
        return bookService.createBook(booksList, token);
    }

    @DeleteMapping("/delete")

    public void deleteBooks(@RequestBody List<String> booksNames
    , @RequestParam String token){
        bookService.deleteBooks(booksNames, token);
    }
}
