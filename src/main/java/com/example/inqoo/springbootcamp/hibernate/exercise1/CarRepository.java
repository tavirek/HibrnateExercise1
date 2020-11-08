package com.example.inqoo.springbootcamp.hibernate.exercise1;

import org.apache.catalina.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findAllCarByBrand (String brand);

        List<Car> findCarByBrand (String brand);
        List<Car> findCarByEngineTypeAndPowerGreaterThanAndBrandNot (String engineType, int power, String brand);

        @Query("select c from Car c where c.engineType = ?1 and c.power > ?2 and c.brand != ?3 ") // zamiast pytajników można użyć @Param i nazwać te parametry. Nie trzeba ich wtedy używać pokolei
        List<Car> searchCarForDress(String engineType, int power, String brand);


}
