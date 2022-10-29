package com.example.library;

import com.example.library.models.Book;
import com.example.library.models.Genre;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	BookRepository bookRepository;
	GenreRepository genreRepository;

	@Autowired
	public LibraryApplication(BookRepository bookRepository, GenreRepository genreRepository) {
		this.bookRepository = bookRepository;
		this.genreRepository = genreRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Lord of the Rings", "18.4.1964", "JRR Tolkien");
		Book book2 = new Book("Narnia", "14.2.1974", "Clive Staples Lewis");
		Book book3 = new Book("Metro 2033", "12.2.2007", "Dmitrij Gluchovskij");
		Book book4 = new Book("Martian", "18.8.2012", "Andy Weir");
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		bookRepository.save(book4);

		Genre genre1 = new Genre("Fantasy");
		Genre genre2 = new Genre("Sci-fi");
		Genre genre3 = new Genre("Post-apocalyptic fiction");;
		genreRepository.save(genre1);
		genreRepository.save(genre2);
		genreRepository.save(genre3);

		book1.setGenre(genre1);
		book2.setGenre(genre1);
		book3.setGenre(genre3);
		book4.setGenre(genre2);
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		bookRepository.save(book4);

		genre1.getBooks().add(book1);
		genre1.getBooks().add(book2);
		genre2.getBooks().add(book4);
		genre3.getBooks().add(book3);
		genreRepository.save(genre1);
		genreRepository.save(genre2);
		genreRepository.save(genre3);
	}
}
