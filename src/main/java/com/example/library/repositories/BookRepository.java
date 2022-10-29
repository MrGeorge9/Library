package com.example.library.repositories;

import com.example.library.DTOs.GenreDTO;
import com.example.library.models.Book;
import com.example.library.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByIdEquals (Integer id);
    List<Book> findByIdNotAndGenreEquals (Integer id, Genre genre);

    List<Book> findByGenreEquals (Genre genre);
}
