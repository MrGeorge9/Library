package com.example.library.repositories;

import com.example.library.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByNameEquals (String genreName);
}
