package pkg.controller;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CaptchaController {

	@GetMapping("verify")
	public String index() {
		return "captcha";
	}

	@PostMapping("verify")
	@ResponseBody
	public String verify(HttpSession session, HttpServletRequest request) {
		String input = request.getParameter("captcha");
		String captcha = session.getAttribute("captcha").toString();
		if (input.equals(captcha))
			return "Correct";
		else
			return "Incorrect";
	}
}
