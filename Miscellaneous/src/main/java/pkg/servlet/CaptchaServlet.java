package pkg.servlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		response.setContentType("image/jpg");
		int totalChars = 6, height = 40, width = 150, circle = 15;
		Font font = new Font("Arial", Font.BOLD, 30);
		Random random = new Random();
		String captcha = (Long.toString(Math.abs(random.nextLong()), 36)).substring(0, totalChars);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = (Graphics2D) bufferedImage.getGraphics();
		for (int i = 0; i < circle; i++) {
			graphics2d.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		}
		graphics2d.setFont(font);
		for (int i = 0; i < totalChars; i++) {
			graphics2d.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			if (i % 2 == 0) {
				graphics2d.drawString(captcha.substring(i, i + 1), 25 * i, 24);
			} else {
				graphics2d.drawString(captcha.substring(i, i + 1), 25 * i, 35);
			}
		}
		OutputStream outputStream = response.getOutputStream();
		ImageIO.write(bufferedImage, "jpeg", outputStream);
		graphics2d.dispose();
		session.setAttribute("captcha", captcha);
	}
}
