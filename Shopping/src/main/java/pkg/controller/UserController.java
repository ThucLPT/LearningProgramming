package pkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pkg.entity.User;
import pkg.service.RoleService;
import pkg.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("register")
	public String register(@ModelAttribute("user") User user) {
		String username = user.getUsername();
		if (!userService.findById(username).isPresent()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole(roleService.findById("ROLE_USER"));
			userService.save(user);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "redirect:/";
		} 
		return "redirect:/register?error";
	}

	@GetMapping("change")
	public String change() {
		return "change";
	}

	@PostMapping("change")
	public String change(@RequestParam("old") String rawOldPass, @RequestParam("new") String rawNewPass) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String encodedOldPass = userDetailsService.loadUserByUsername(username).getPassword();
		if (passwordEncoder.matches(rawOldPass, encodedOldPass)) {
			User user = userService.findById(username).get();
			user.setPassword(passwordEncoder.encode(rawNewPass));
			userService.save(user);
			return "redirect:/";
		}
		return "redirect:/change?error";
	}
}
