package pkg.util;

import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
	public static String upload(ServletContext servletContext, MultipartFile file) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName = dateFormat.format(new Date()) + file.getOriginalFilename();
			Path path = Paths.get(servletContext.getRealPath("/WEB-INF/upload/" + fileName));
			Files.write(path, file.getBytes());
			return fileName;
		} catch (Exception e) {
			return null;
		}
	}
}
