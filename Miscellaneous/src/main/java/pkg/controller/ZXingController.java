package pkg.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pkg.util.ZXingUtil;

@Controller
public class ZXingController {

	@GetMapping("qrcode/{id}")
	public void qrCode(@PathVariable String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream stream = response.getOutputStream();
		stream.write(ZXingUtil.getQRCode(id, 200, 200));
		stream.flush();
		stream.close();
	}

	@GetMapping("barcode/{id}")
	public void barCode(@PathVariable String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream stream = response.getOutputStream();
		stream.write(ZXingUtil.getBarCode(id, 200, 200));
		stream.flush();
		stream.close();
	}
}
