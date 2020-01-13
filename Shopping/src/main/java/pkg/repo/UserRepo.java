package pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

}
