package pkg.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("upload")
	public String index() {
		return "upload";
	}

	@GetMapping("dragdrop")
	public String dragDrop() {
		return "dragdrop";
	}

	@PostMapping("upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile[] files) throws Exception {
		File uploadFolder = new File("upload");
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		for (MultipartFile file : files) {
			file.transferTo(new File(uploadFolder.getAbsolutePath() + File.separator + file.getOriginalFilename()));
		}
		return "Uploaded";
	}
}
