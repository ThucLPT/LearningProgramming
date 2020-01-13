package pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.entity.Role;
import pkg.repo.RoleRepo;

@Service
public class RoleService {
	@Autowired
	private RoleRepo roleRepo;

	public Role findById(String name) {
		return roleRepo.findById(name).get();
	}
}
