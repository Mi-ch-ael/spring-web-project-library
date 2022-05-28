package com.example.springwebprojectbookmanagement.controllers;

import com.example.springwebprojectbookmanagement.domain.Book;
import com.example.springwebprojectbookmanagement.domain.ReservationInfo;
import com.example.springwebprojectbookmanagement.helpers.DateHelper;
import com.example.springwebprojectbookmanagement.storage.BookRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

@Controller
public class LibraryController {
    private final BookRepository storage;

    public LibraryController(BookRepository storage) {
        this.storage = storage;
    }

    @GetMapping("/")
    public String getRoot(Model model) {
        model.addAttribute("library", storage.findAll());
        model.addAttribute("dateHelper", new DateHelper());
        return "root";
    }

    @GetMapping("/book/{bookId}")
    public String getBook(Model model, @PathVariable long bookId) {
        Optional<Book> boxedBook = storage.findById(bookId);
        if(boxedBook.isEmpty()) return "not_found";
        model.addAttribute("book", boxedBook.get());
        model.addAttribute("dateHelper", new DateHelper());
        return "book";
    }

    @GetMapping("/sort/all")
    @ResponseBody
    public Iterable<Book> getAllBooks() {
        return storage.findAll();
    }

    @GetMapping("/sort/available")
    @ResponseBody
    public Iterable<Book> getAvailableBooks() {
        return storage.findAllByGivenToIsNull();
    }

    @GetMapping("/sort/expired")
    @ResponseBody
    public Iterable<Book> getExpiredBooks() {
        return storage.findAllByReturnDateTimestampLessThan(new DateHelper().timestamp);
    }

    @PostMapping("/book/{bookId}/delete")
    public String deleteBook(Model model, @PathVariable long bookId) {
        if(storage.findById(bookId).isEmpty()) return "not_found";
        storage.deleteById(bookId);
        model.addAttribute("library", storage.findAll());
        model.addAttribute("dateHelper", new DateHelper());
        return "root";
    }

    @PostMapping(path="/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addBook(Model model, Book book) {
        if(book.getAuthor().equals("")) book.setAuthor("[Not specified]");
        if(book.getLanguage().equals("")) book.setLanguage("[Not specified]");
        storage.save(book);
        model.addAttribute("library", storage.findAll());
        model.addAttribute("dateHelper", new DateHelper());
        return "root";
    }

    @PostMapping(path = "/book/{bookId}/take", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String takeBook(Model model, @PathVariable long bookId, @ModelAttribute("data") ReservationInfo data) throws ParseException {
        Optional<Book> boxedBook = storage.findById(bookId);
        if(boxedBook.isEmpty()) return "not_found";
        Book book = boxedBook.get();
        if(book.getGivenTo() != null) return "not_found";
        book.setReturnDateTimestamp(new DateHelper().formatter.parse(data.getReturnDate()).getTime());
        book.setGivenTo(data.getGivenTo());
        storage.save(book);
        model.addAttribute("book", book);
        model.addAttribute("dateHelper", new DateHelper());
        return "book";
    }

    @PostMapping(path = "/book/{bookId}/return", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String returnBook(Model model, @PathVariable long bookId) {
        Optional<Book> boxedBook = storage.findById(bookId);
        if(boxedBook.isEmpty()) return "not_found";
        Book book = boxedBook.get();
        book.setGivenTo(null);
        book.setReturnDateTimestamp(null);
        storage.save(book);
        model.addAttribute("book", book);
        model.addAttribute("dateHelper", new DateHelper());
        return "book";
    }

    @PostMapping(path = "/book/{bookId}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String alterBook(Model model, @PathVariable long bookId, Book newBookData) {
        Optional<Book> boxedBook = storage.findById(bookId);
        if(boxedBook.isEmpty()) return "not_found";
        Book book = boxedBook.get();
        if(!newBookData.getAuthor().equals("")) {
            book.setAuthor(newBookData.getAuthor());
        }
        if(!newBookData.getTitle().equals("")) {
            book.setTitle(newBookData.getTitle());
        }
        book.setYear(newBookData.getYear());
        if(!newBookData.getLanguage().equals("")) {
            book.setLanguage(newBookData.getLanguage());
        }
        storage.save(book);
        model.addAttribute("book", book);
        model.addAttribute("dateHelper", new DateHelper());
        return "book";
    }
}
