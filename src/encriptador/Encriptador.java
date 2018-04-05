/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author House
 */
public class Encriptador {

    /**
     * @param args the command line arguments
     */
      private static byte[] iv =
      { 0x0a, 0x01, 0x02, 0x03, 0x04, 0x0b, 0x0c, 0x0d };
        public static void main(String[] args) throws IOException, NoSuchAlgorithmException, Exception {
        File file = new File("C:\\Users\\House\\Pictures\\prueba\\Juno_Portrait_002_4k.png");
        String s = "hksjdhaksjd";
        byte[] array = Files.readAllBytes(file.toPath());
        String tipoCifrado = "DES/ECB/PKCS5Padding";
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(56); //56 is the key size, fixed for DES
            SecretKey key = kg.generateKey();
        byte[] encrypted = encrypt(array, key, tipoCifrado);
        GestionadorArchivo.guardarArchivito(encrypted, "encriptado.txt");
    }
    private static byte[] encrypt(byte[] inpBytes,
    SecretKey key, String xform) throws Exception {
    Cipher cipher = Cipher.getInstance(xform);
    IvParameterSpec ips = new IvParameterSpec(iv);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    
    return cipher.doFinal(inpBytes);
  }

    
}
