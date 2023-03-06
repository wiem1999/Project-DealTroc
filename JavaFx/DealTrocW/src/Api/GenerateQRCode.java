/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;
import Entities.Produit;
import Entities.Promo;
import java.io.File;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  
/**
 *
 * @author ASUS
 */
public class GenerateQRCode {
    //static function that creates QR Code  
public static void generateQRcode(Promo promo, String path) throws WriterException, IOException {
    // create the data string to encode in the QR code
    String data = promo.getTitre()+ "\n"
                + promo.getDescription()+ "\n"
                + "Price: " + promo.getPrix()+ "\n"
                + "Pourcentage: " + promo.getPourcentage();
    
    // set the QR code parameters
    int width = 300;
    int height = 300;
    String charset = "UTF-8";
    Map<EncodeHintType, Object> hints = new HashMap<>();
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    
    // encode the data and write the QR code image to the file
    BitMatrix matrix = new MultiFormatWriter().encode(
        new String(data.getBytes(charset), charset),
        BarcodeFormat.QR_CODE,
        width,
        height,
        hints
    );
    MatrixToImageWriter.writeToFile(matrix, "PNG", new File(path));
}

    
}
