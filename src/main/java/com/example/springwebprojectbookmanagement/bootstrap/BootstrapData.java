package com.example.springwebprojectbookmanagement.bootstrap;

import com.example.springwebprojectbookmanagement.domain.Book;
import com.example.springwebprojectbookmanagement.storage.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository storage;

    public BootstrapData(BookRepository storage) {
        this.storage = storage;
    }

    @Override
    public void run(String... args) {
        Book[] initialBookCollection = new Book[]{
                new Book("Oliver Twist", "Charles Dickens",
                        1978, "English", null, null),
                new Book("The Lord of the Rings", "John R. R. Tolkien",
                        2002, "English", null, null),
                new Book("All Quiet on the Western Front", "Erich Maria Remark",
                        1986, "German", null, null)
        };
        this.storage.saveAll(Arrays.asList(initialBookCollection));
    }
}
