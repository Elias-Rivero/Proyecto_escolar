
package es.ies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jorge
 */
public class Escritor {

    File file;

    /**
     *
     * @param file
     */
    public Escritor(File file) {
        this.file = file;
    }

    /**
     *
     * @param cj
     * escribe un objeto en un fichero comprobando si esta vacio o no
     */
    public void escribe(String cj) {

        try (BufferedWriter oos = new BufferedWriter(new FileWriter(file))) {
            if (cj != null) {
                oos.write(cj);
                oos.flush();
            } else {
                System.out.println("objeto vacio");
            }
        } catch (IOException ioe) {
        } catch (Exception e) {
        }
    }

}
