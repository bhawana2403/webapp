package com.example.webapp.bootstrap;

import com.example.webapp.domain.Author;
import com.example.webapp.domain.Book;
import com.example.webapp.domain.Publisher;
import com.example.webapp.repositories.AuthorRepository;
import com.example.webapp.repositories.BookRepository;
import com.example.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    // Dependency injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub = new Publisher();
        pub.setName("SFG Publications");
        pub.setCity("St Berg");
        pub.setState("Gk");
        publisherRepository.save(pub);
        System.out.println("Number of publishers:"+publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("Java J2EE development without EJB","1234512345");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        System.out.println("Started in BootStrap");
        System.out.println("Number of books :"+bookRepository.count());
    }
}
