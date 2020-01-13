package pkg.util;

import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZXingUtil {
	public static byte[] getQRCode(String text, int width, int height) throws Exception {
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(matrix, "png", stream);
		return stream.toByteArray();
	}

	public static byte[] getBarCode(String text, int width, int height) throws Exception {
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hashtable = new Hashtable<>();
		hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		Writer writer = new Code128Writer();
		BitMatrix matrix = writer.encode(text, BarcodeFormat.CODE_128, width, height);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(matrix, "png", stream);
		return stream.toByteArray();
	}
}
