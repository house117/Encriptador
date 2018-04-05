/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

/**
 *
 * @author House
 */
public class DesencriptadorxD {
            File file = new File("test.txt");
        
        
        FileReader reader = new FileReader(file);
        
        int caracter = 0;
        
        while(caracter != -1){
            caracter = reader.read();
            char c = (char)caracter;
            System.out.print(c);
        }
        
        
}
