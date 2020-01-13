package pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.District;

public interface DistrictRepository extends JpaRepository<District, Integer> {

}
