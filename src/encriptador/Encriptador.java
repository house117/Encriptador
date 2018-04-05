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
        public static void main(String[] args) throws IOException, NoSuchAlgorithmException, Exception {
        File file = new File("C:\\Users\\House\\Pictures\\prueba\\village_field_poland_mountains_grass_snow_115890_3840x2400");
        String s = "hksjdhaksjd";
        byte[] array = Files.readAllBytes(file.toPath());
        String tipoCifrado = "DES/ECB/PKCS5Padding";
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(56); //56 is the key size, fixed for DES
            
            SecretKey key = kg.generateKey();
            
        byte[] encrypted = encrypt(array, key, tipoCifrado);
        GestionadorArchivo.guardarArchivito(encrypted, "encriptado.txt");
        GestionadorArchivoKey.guardarArchivito(key, "llave.txt");
    }
    private static byte[] encrypt(byte[] inpBytes,
    SecretKey key, String xform) throws Exception {
    Cipher cipher = Cipher.getInstance(xform);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    
    return cipher.doFinal(inpBytes);
  }
        private static byte[] decrypt(byte[] inpBytes,
        SecretKey key, String xform) throws Exception {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(inpBytes);
    }

    
}
