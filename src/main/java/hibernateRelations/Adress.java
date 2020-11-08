package hibernateRelations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String streetName;
    private Integer houseNr;
    private String postalCode;
    @OneToMany
    private List<Person> persons = new ArrayList<>();


    public Adress(String city, String streetName, Integer houseNr, String postalCode, List persons) {
        this.city = city;
        this.streetName = streetName;
        this.houseNr = houseNr;
        this.postalCode = postalCode;
        this.persons = persons;

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

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNr=" + houseNr +
                ", postalCode='" + postalCode + '\'' +
                ", persons=" + persons +
                '}';
    }
}
