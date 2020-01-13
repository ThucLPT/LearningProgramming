package pkg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.entity.User;
import pkg.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public Optional<User> findById(String username) {
		return userRepo.findById(username);
	}

	public User save(User user) {
		return userRepo.save(user);
	}
}
