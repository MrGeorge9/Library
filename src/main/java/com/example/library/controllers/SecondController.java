package com.example.library.controllers;

import com.example.library.DTOs.GenreDTO;
import com.example.library.DTOs.UpdateBook;
import com.example.library.services.SecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecondController {

    private final SecondService secondService;

    @Autowired
    public SecondController(SecondService secondService) {
        this.secondService = secondService;
    }

    @PostMapping("/booksOfSameGenre")
    public ResponseEntity sameGenreBooks (@RequestBody GenreDTO genreDTO){
        return secondService.getBooksByGenre(genreDTO);
    }

    @PutMapping("/ChangeBook/{id}")
    public void sameGenreBooks (@RequestBody UpdateBook updateBook, @PathVariable Integer id){
        secondService.updateBook(updateBook,id);
    }
}
