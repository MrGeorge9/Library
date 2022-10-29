package com.example.library.services;

import com.example.library.models.Book;
import com.example.library.models.Genre;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FirstServiceIml implements FirstService{

    BookRepository bookRepository;
    GenreRepository genreRepository;

    @Autowired
    public FirstServiceIml(BookRepository bookRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Book getBookDetails (Integer id) {
        return bookRepository.findByIdEquals(id);
    }
    public Genre getBookGenre (Integer id){
        Book book = bookRepository.findByIdEquals(id);
        return book.getGenre();
    }
    @Override
    public List<Book> getAllBooksWithSameGenre (Integer id){
        return bookRepository.findByIdNotAndGenreEquals(id, getBookGenre(id));
    }

    @Override
    public List<Genre> getAllgenres (){
        return genreRepository.findAll();
    }

    public void addBook (String name,String date,String author,String genreName){
        Genre genre = genreRepository.findByNameEquals(genreName);
        Book book = new Book(name,date,author);
        book.setGenre(genre);
        bookRepository.save(book);
        genre.getBooks().add(book);
        genreRepository.save(genre);
    }

    public void addBookNewGenre (String name,String date,String author,String newGenreName){
        Genre genre = new Genre(newGenreName);
        genreRepository.save(genre);
        Book book = new Book(name,date,author);
        book.setGenre(genre);
        bookRepository.save(book);
        genre.getBooks().add(book);
        genreRepository.save(genre);
    }

    public void addGenre (String name){
        Genre genre = new Genre(name);
        genreRepository.save(genre);
    }
}
