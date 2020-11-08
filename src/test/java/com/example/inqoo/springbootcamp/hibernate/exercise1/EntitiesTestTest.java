package com.example.inqoo.springbootcamp.hibernate.exercise1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EntitiesTestTest {


    @Autowired
    CarRepository carRepository;
    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void init() {
        carRepository.save(new Car("Audi", "A4", "diesel", 120, 5, "czerwony"));
        carRepository.save(new Car("Audi", "A3", "diesel", 140, 5, "czarny"));
        carRepository.save(new Car("Audi", "A1", "fuel", 100, 3, "czerwony"));
        carRepository.save(new Car("Audi", "A6", "diesel", 160, 5, "bialy"));

        bookRepository.save(new Book("ISBN1", "title1", 2, LocalDate.of(1990, 4, 3), "sdasd", 200));


    }

    @Test
    public void shouldFindOtherCars() {

        List<Car> allCars = carRepository.findAll();
        assertThat(allCars.size()).isEqualTo(4);
    }

    @Test
    public void shouldReturnBookByTitleNamePageCover() {
        //when
        List<Book> booksByEditionCoverPageCount = bookRepository.findBookByEditionDateBeforeAndCoverTypeAndPageCountLessThan(LocalDate.of(1991, 5, 20), "paper", 101);

        //then
        assertThat(booksByEditionCoverPageCount.size()).isEqualTo(1);
    }

    @Test
    public void should() {

    List<Car> searchCarForDress = carRepository.searchCarForDress("diesel", 130, "Renault");
        //then
        assertThat(searchCarForDress.size()).isEqualTo(2);
    }
}