package pkg.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import pkg.model.MyFile;
import pkg.util.UploadUtil;

@Controller
public class EditorController implements ServletContextAware {
	private ServletContext servletContext;

	@GetMapping("")
	public String index() {
		return "index";
	}

	@GetMapping("browse")
	public String browse(Model model) {
		File folder = new File(servletContext.getRealPath("/WEB-INF/upload"));
		model.addAttribute("files", folder.listFiles());
		return "browse";
	}

	@PostMapping(value = "upload", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<MyFile> upload(@RequestParam("upload") MultipartFile file) {
		String fileName = UploadUtil.upload(servletContext, file);
		return new ResponseEntity<MyFile>(new MyFile("/upload/" + fileName), HttpStatus.OK);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
