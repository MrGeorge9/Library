package com.example.library.services;

import com.example.library.DTOs.GenreDTO;
import com.example.library.DTOs.UpdateBook;
import com.example.library.models.Book;
import com.example.library.models.Genre;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecondServiceIml implements SecondService{

    BookRepository bookRepository;
    GenreRepository genreRepository;

    @Autowired
    public SecondServiceIml(BookRepository bookRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    public ResponseEntity getBooksByGenre (GenreDTO genreDTO){
        String genreName = genreDTO.getGenre();
        Genre genre = genreRepository.findByNameEquals(genreName);
        if (genre==null){
            return ResponseEntity.status(204).body("No such genre");
        }
        List<Book> books = bookRepository.findByGenreEquals(genre);
        if (books.size()==0){
            return ResponseEntity.status(204).body("No books in this genre");
        }
        List<String> booksNames = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            booksNames.add(books.get(i).getName());
        }
        return ResponseEntity.ok(booksNames);
    }

    public void updateBook (UpdateBook updateBook, Integer id){
        Book book = bookRepository.findByIdEquals(id);
        book.setName(updateBook.getName());
        book.setAuthor(updateBook.getAuthor());
        Genre genre = genreRepository.findByNameEquals(updateBook.getGenre());
        book.setGenre(genre);
        bookRepository.save(book);
        genre.getBooks().add(book);
        genreRepository.save(genre);
    }
}
