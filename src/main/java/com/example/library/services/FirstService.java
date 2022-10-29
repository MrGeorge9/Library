package com.example.library.services;

import com.example.library.models.Book;
import com.example.library.models.Genre;

import java.util.List;

public interface FirstService {

    List<Book> getAllBooks ();
    Book getBookDetails (Integer id);
    List<Book> getAllBooksWithSameGenre (Integer id);
    List<Genre> getAllgenres ();
    void addBook (String name,String date,String author,String genreName);
    void addBookNewGenre (String name,String date,String author,String newGenreName);
    void addGenre (String name);
}
