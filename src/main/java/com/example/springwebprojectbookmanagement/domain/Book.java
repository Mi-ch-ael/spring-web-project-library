package com.example.springwebprojectbookmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    private int year;
    private String language;
    private String givenTo = null;
    //private String returnDate;
    private Long returnDateTimestamp = null;

    public Book() { }

    public Book(String title, String author, int year, String language, String givenTo, Long returnDateTimestamp) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.language = language;
        this.givenTo = givenTo;
        this.returnDateTimestamp = returnDateTimestamp;
    }

    public Book(String title, String author, int year, String language) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(String givenTo) {
        this.givenTo = givenTo;
    }

    public Long getReturnDateTimestamp() {
        return returnDateTimestamp;
    }

    public void setReturnDateTimestamp(Long returnDateTimestamp) {
        this.returnDateTimestamp = returnDateTimestamp;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
