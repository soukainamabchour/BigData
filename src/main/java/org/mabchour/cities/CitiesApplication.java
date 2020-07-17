package org.mabchour.cities;

import org.mabchour.cities.Models.City;
import org.mabchour.cities.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitiesApplication implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;
    public static void main(String[] args) {
        SpringApplication.run(CitiesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       //cityRepository.save(new City(null,"BenSlimane","Morocco","casa-setat","1234567898765432"));
        System.out.println(cityRepository.findAll().get(134));
    }
}
