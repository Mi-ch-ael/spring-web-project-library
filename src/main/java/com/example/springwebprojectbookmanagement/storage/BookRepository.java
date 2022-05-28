package com.example.springwebprojectbookmanagement.storage;

import com.example.springwebprojectbookmanagement.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAllByGivenToIsNull();
    Iterable<Book> findAllByReturnDateTimestampLessThan(long today);
}
