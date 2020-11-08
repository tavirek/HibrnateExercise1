package hibernateRelations;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class PersonTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AdressRepository adressRepository;

    @BeforeEach
    void init(){

        Adress adress1 = new Adress("Katowice", "Twarda", 5, "40-123");
        Adress adress2 = new Adress("Katowice", "Miekka", 15, "40-123");
        Adress adress3 = new Adress("Katowice", "Szeroka", 25, "40-123");
        Adress adress4 = new Adress("Katowice", "Zielona", 53, "40-123");

        adressRepository.save(adress1);
        adressRepository.save(adress2);
        adressRepository.save(adress3);
        adressRepository.save(adress4);


        Person person1 = new Person("Person1", "Kowalski", "11111111111", 20 );
        Person person2 = new Person("Person2", "Kowalski", "22222222222", 30);
        Person person3 = new Person("Person3", "Kowalski", "33333333333", 40);
        Person person4 = new Person("Person4", "Kowalski", "44444444444", 50);
        Person person5 = new Person("Person5", "Kowalski", "55555555555", 60);
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.save(person5);


    }

//    @Test
//    public void personHaveAdress() {
//        List<Person> adressToPerson = personRepository.findAll();
//
//        System.out.println("result adress" + adressToPerson);
//    }

//    @Test
//    public void should() {
//
//        //when
//        List<Person> persons = personRepository.findAll();
//        //then
//        persons.forEach(person -> assertThat(person.getAdress()).isNotNull());
//
//    }



    @Test
    public void shouldPersist() {
        //given
        Person person1 = new Person("Person1", "Kowalski", "11111111111", 20);
        Person person2 = new Person("Person2", "Kowalski", "22222222222", 30);

        Adress adress1 = new Adress("Katowice", "Twarda", 5, "40-123");
        Adress adress2 = new Adress("Katowice", "Miekka", 15, "40-123");

        Person savedPerson1 = personRepository.save(person1);
        Person savedPerson2 = personRepository.save(person2);

        Adress savedAdres1 = adressRepository.save(adress1);
        Adress savedAdres2 = adressRepository.save(adress2);


        Optional<Person> byId = personRepository.findById(savedPerson1.getId());
        Optional<Adress> byId1 = adressRepository.findById(savedAdres1.getId());

        //when
        adress1.setPersons(Stream.of(person1, person2).collect(Collectors.toSet()));
        adress2.setPersons(Stream.of(person1, person2).collect(Collectors.toSet()));
        adressRepository.save(adress1);
        adressRepository.save(adress2);

        //then
        List<Adress> allAdress = adressRepository.findAll();
        List<Person> allPersons = personRepository.findAll();
        System.out.println("result: " + allAdress);
        System.out.println("authors: " + allPersons);

        assertThat(allAdress).isNotEmpty();
        assertThat(allPersons).isNotEmpty();
    }

}