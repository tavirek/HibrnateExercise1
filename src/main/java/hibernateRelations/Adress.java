package hibernateRelations;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String streetName;
    private Integer houseNr;
    private String postalCode;
    @ManyToMany ( fetch = FetchType.LAZY)
     Set<Person> persons = new HashSet<>();


    public Adress(String city, String streetName, Integer houseNr, String postalCode) {
        this.city = city;
        this.streetName = streetName;
        this.houseNr = houseNr;
        this.postalCode = postalCode;


    }

    public Adress(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(Integer houseNr) {
        this.houseNr = houseNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNr=" + houseNr +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }


}
