package com.example.librarydemo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.model.Book;

@RestController
public class LibraryController {

    // In-memory book list
    private List<Book> bookList = new ArrayList<>();

    // 2. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 3. /count
    @GetMapping("/count")
    public int getBookCount() {
        return 100;
    }

    // 4. /price
    @GetMapping("/price")
    public double getSamplePrice() {
        return 499.99;
    }

    // 5. /books
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java Basics", "Spring Boot Guide", "Data Structures");
    }

    // 6. /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 7. /search?title=Java
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book with title: " + title;
    }

    // 8. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 9. /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 10. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}