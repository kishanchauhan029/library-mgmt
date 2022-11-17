package co.pragra.learning.librarymgmt;

import co.pragra.learning.librarymgmt.entity.Author;
import co.pragra.learning.librarymgmt.entity.Book;
import co.pragra.learning.librarymgmt.repo.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LibraryMgmtApplication {

    private BookRepo repo;

    public LibraryMgmtApplication(BookRepo repo){
        this.repo = repo;
    }
    public static void main(String[] args) {
        SpringApplication.run(LibraryMgmtApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            //repo.createSchema();
//            repo.create(Book.builder()
//                            .id(1)
//                    .isbn("ISBN53456").category("Programming")
//                    .author(Author.builder().id(1).name("Kishan").build())
//                    .createDate(new Date())
//                    .publishDate(new Date())
//                    .title("Awesome Spring")
//                    .build()
//            );
            List<Book> books = repo.getAll(Collections.emptyMap());
            System.out.println(books);
        };
    }
}
