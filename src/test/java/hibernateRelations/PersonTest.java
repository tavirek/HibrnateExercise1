package hibernateRelations;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

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
        Person person1 = new Person("Person1", "Kowalski", "11111111111", 20);
        Person person2 = new Person("Person2", "Kowalski", "22222222222", 30);
        Person person3 = new Person("Person3", "Kowalski", "33333333333", 40);
        Person person4 = new Person("Person4", "Kowalski", "44444444444", 50);
        Person person5 = new Person("Person5", "Kowalski", "55555555555", 60);
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.save(person5);

        Adress adress1 = new Adress("Katowice", "Twarda", 5, "40-123",person1);
        Adress adress2 = new Adress("Katowice", "Miekka", 15, "40-123",person2);
        Adress adress3 = new Adress("Katowice", "Szeroka", 25, "40-123",person2);
        Adress adress4 = new Adress("Katowice", "Zielona", 53, "40-123",person3);

        adressRepository.save(adress1);
        adressRepository.save(adress2);
        adressRepository.save(adress3);
        adressRepository.save(adress4);

    }

    @Test
    public void person2Have2Flats() {
        List<Adress> adressBelongToPerson2 = adressRepository.findAll();

        System.out.println("result adress" + adressBelongToPerson2);
    }

}