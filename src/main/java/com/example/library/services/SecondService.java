package com.example.library.services;

import com.example.library.DTOs.GenreDTO;
import com.example.library.DTOs.UpdateBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface SecondService {

    ResponseEntity getBooksByGenre (GenreDTO genreDTO);
    void updateBook (UpdateBook updateBook, Integer id);
}
