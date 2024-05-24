package io.nayuki.qrcodegen;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Sagar Basak (2021CSB008)
 * 
 */
public class QRCodeReaderDemo {

    public static String readQRCode(String filePath) throws IOException, NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(new File(filePath));
        BufferedImageLuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }

    public static void main(String[] args) {
        File qrCodeDirectory = new File("QRCodes");
        File[] qrCodeFiles = qrCodeDirectory.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

        if (qrCodeFiles != null) {
            for (File qrCodeFile : qrCodeFiles) {
                String qrFileName = qrCodeFile.getName();
                String fileNameWithoutExtension = qrFileName.substring(0, qrFileName.lastIndexOf('.'));
                String detailsFilePath = "ExtractedQRInfo/" + fileNameWithoutExtension + "_extracted.txt";

                try {
                    String decodedText = readQRCode(qrCodeFile.getPath());
                    // System.out.println("Decoded text from " + qrFileName + ": " + decodedText);

                    // Write details to file
                    File outputDir = new File("ExtractedQRInfo");
                    if (!outputDir.exists()) {
                        outputDir.mkdirs();
                    }

                    try (FileOutputStream fos = new FileOutputStream(detailsFilePath, true)) {
                        fos.write((decodedText + "\n").getBytes());
                    }
                } catch (IOException | NotFoundException e) {
                    System.err.println("Could not read QR Code from " + qrFileName + ": " + e.getMessage());
                }
            }
        } else {
            System.err.println("No QR Code files found in the QRCodes directory.");
        }
    }
}