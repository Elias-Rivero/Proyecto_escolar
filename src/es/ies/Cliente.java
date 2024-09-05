package es.ies;

import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Cliente extends Persona implements Sorteable {

    private String idCliente;
    static int numCompras=0;

    /**
     *
     */
    public Cliente() {
        contador++;

    }

    /**
     *
     * @param idCliente
     * @param numCompras
     * @param nombre
     * @param direccion
     * @param telefono
     */
    public Cliente(String idCliente, int numCompras, String nombre,
            String direccion, String telefono) {
        super(nombre, direccion, telefono);
        this.numCompras = numCompras;
        contador++;
        if (validarId(idCliente)) {
            this.idCliente = idCliente;
        } else {
            this.idCliente = generarId();
        }
        if (participarSorteo(idCliente,numCompras)) {
            JOptionPane.showMessageDialog(null, "Ha ganado el sorteo",
                    "ID de cliente: " + this.idCliente,
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     *
     * @return
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     */
    public int getNumCompras() {
        return numCompras;
    }

    /**
     *
     * @param numCompras
     */
    public void setNumCompras(int numCompras) {
        this.numCompras = numCompras;
        if (participarSorteo(idCliente,numCompras)) {
            JOptionPane.showMessageDialog(null, "Ha ganado el sorteo",
                    "ID de cliente: " + this.idCliente,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *
     * @param num
     */
    public void comprar(int num) {
        setNumCompras(num);
    }

    /**
     *
     * @param id
     * @return
     * Valida que el id sea mayor que 5 carácteres.
     */
    @Override
    public boolean validarId(String id) {
        if (id.length() <5) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @param idCliente
     * @param num
     * @return
     * Si el numero de compras supera las 10 participa en un sorteo al 50%
     */
    @Override
    public boolean participarSorteo(String idCliente,int num) {
        int var = 0;
        if (numCompras > 10) {
            var = (int) (Math.random() * 2);
        }
        if (var == 1) {
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @return
     * Genera un id de numeros aleatorios de longitud 10.
     */
    @Override
    public String generarId() {
        String id;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append((int) Math.ceil(Math.random() * i));
        }
        id = sb.toString();

        return id;
    }

}
