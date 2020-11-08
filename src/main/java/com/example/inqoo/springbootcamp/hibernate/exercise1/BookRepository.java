package com.example.inqoo.springbootcamp.hibernate.exercise1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findAllBooksByTitle(String title);


    List<Book> findBookByTitle(String title);

    List<Book> findBookByEditionDateBeforeAndCoverTypeAndPageCountLessThan(LocalDate editionDate, String CoverType, int pageCount);



}
