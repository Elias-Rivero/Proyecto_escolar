package es.ies;

import javax.swing.JOptionPane;
public class Cliente extends Persona implements Sorteable {

    private String idCliente;
    static int numCompras=0;

    public Cliente() {
        contador++;
    }
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

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumCompras() {
        return numCompras;
    }

    public void setNumCompras(int numCompras) {
        this.numCompras = numCompras;
        if (participarSorteo(idCliente,numCompras)) {
            JOptionPane.showMessageDialog(null, "Ha ganado el sorteo",
                    "ID de cliente: " + this.idCliente,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void comprar(int num) {
        setNumCompras(num);
    }

    @Override
    public boolean validarId(String id) {
        if (id.length() <5) {return false;} else {return true;}
    }

    @Override
    public boolean participarSorteo(String idCliente,int num) {
        int var = 0;
        if (numCompras > 10) {
            var = (int) (Math.random() * 2);
        }
        if (var == 1) {return true;} else {return false;}
    }

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
