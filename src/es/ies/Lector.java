/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ies;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jorge
 */
public class Lector {

    File file;

    /**
     *
     * @param file
     */
    public Lector(File file) {
        this.file = file;
    }
//busca e imprime objetos de un fichero

    /**
     *
     * @return
     * Lee de un fichero la primera linea y la devuelve.
     */
    public String verContenido() {
        BufferedReader ois = null;
        try {
            ois = new BufferedReader(new FileReader(file));
                return ois.readLine();
        } catch (EOFException eof) {
            System.out.println("Fichero acabado");
        } catch (FileNotFoundException fnfe) {
            System.out.println("fichero no encontrado" + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("error entrada-salida" + ioe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println("No se ha podido cerrar" + ioe.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

}
