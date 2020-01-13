package pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
