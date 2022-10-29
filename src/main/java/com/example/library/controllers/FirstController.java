package com.example.library.controllers;

import com.example.library.models.Genre;
import com.example.library.services.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

    private final FirstService firstService;

    @Autowired
    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/")
    public String getAllBooks (Model model){
        model.addAttribute("books", firstService.getAllBooks());
        model.addAttribute("genres", firstService.getAllgenres());
        return "mainPage";
    }

    @GetMapping("/bookDetails/{id}")
    public String bookDetails (Model model, @PathVariable Integer id){
        model.addAttribute("book", firstService.getBookDetails(id));
        model.addAttribute("booksWithSameGenre", firstService.getAllBooksWithSameGenre(id));
        return "bookDetails";
    }

    @PostMapping("/addBook")
    public String addBook (@RequestParam String name, @RequestParam String date,
                           @RequestParam String author, @RequestParam String genreName, @RequestParam String newGenreName){
        if(newGenreName.equals("")){
            firstService.addBook(name,date,author,genreName);
        } else {
            firstService.addBookNewGenre(name,date,author,newGenreName);
        }
        return "redirect:/";
    }

    @PostMapping("/addGenre")
    public String addGenre (@RequestParam String name){
        firstService.addGenre(name);
        return "redirect:/";
    }
}
