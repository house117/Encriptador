/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import encriptador.Encriptador;
import encriptador.GestionadorArchivo;
import java.io.File;

/**
 *
 * @author House
 */
public class main {
    public static void main(String[] args) throws Exception {
        Encriptador encriptador = new Encriptador();
        File file = new File("C:\\Users\\House\\Pictures\\prueba\\village_field_poland_mountains_grass_snow_115890_3840x2400.jpg");
        
        String key = "lolazodasdfsafdasdf";
        
        GestionadorArchivo.guardarArchivito(encriptador.encrypt(file, key), key);
    }
}
