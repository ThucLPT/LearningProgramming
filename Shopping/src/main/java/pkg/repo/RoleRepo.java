package pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.Role;

public interface RoleRepo extends JpaRepository<Role, String> {

}
