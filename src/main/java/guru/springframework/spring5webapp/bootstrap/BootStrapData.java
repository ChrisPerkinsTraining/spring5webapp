package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author john = new Author("John", "Wiseman");
        Book sasHandbook = new Book("SAS Survival Handbook", "432129i9213");
        john.getBooks().add(sasHandbook);
        sasHandbook.getAuthors().add(john);

        authorRepository.save(john);
        bookRepository.save(sasHandbook);

        Author thomas = new Author("Thomas", "Asbridge");
        Book greatKnight = new Book("The Greatest Knight", "432875461");
        Author per = new Author("Per", "Asbridge");
        thomas.getBooks().add(greatKnight);
        greatKnight.getAuthors().add(thomas);
        greatKnight.getAuthors().add(per);

        authorRepository.save(thomas);
        authorRepository.save(per);
        bookRepository.save(greatKnight);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
