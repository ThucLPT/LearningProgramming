package pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

}
