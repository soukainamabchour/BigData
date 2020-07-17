package org.mabchour.cities.Repositories;

import org.mabchour.cities.Models.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City,String> {
    public Page<City> findByNameContainsIgnoreCase(String nom, Pageable pageable);
}
