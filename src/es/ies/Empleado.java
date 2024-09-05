
package es.ies;

import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Empleado extends Persona implements Sorteable, Comparable {

    private String idEmpleado;
    private int puesto;
    private int aniosTrabajados;

    /**
     *
     */
    public Empleado() {
        contador++;
    }

    /**
     *
     * @param idEmpleado
     * @param puesto
     * @param aniosTrabajados
     */
    public Empleado(String idEmpleado, int puesto, int aniosTrabajados) {
        this.idEmpleado = idEmpleado;
        this.puesto = puesto;
        this.aniosTrabajados = aniosTrabajados;
        contador++;
        if (validarId(idEmpleado)) {
            this.idEmpleado = idEmpleado;
        } else {
            this.idEmpleado = generarId();
        }
        if (participarSorteo(idEmpleado,aniosTrabajados)) {
            System.out.println("Has ganado el sorteo de empleados!!!");
            System.out.println("Num de cliente: " + idEmpleado);
        }
    }

    /**
     *
     * @param idEmpleado
     * @param puesto
     * @param aniosTrabajados
     * @param nombre
     * @param apellido
     * @param direccion
     * @param telefono
     * En el constructor valida y genera si es necesario un id.
     */
    public Empleado(String idEmpleado, int puesto, int aniosTrabajados, 
            String nombre, String apellido, String direccion, String telefono) {
        super(nombre, direccion, telefono);
        this.idEmpleado = idEmpleado;
        this.puesto = puesto;
        this.aniosTrabajados = aniosTrabajados;
        contador++;
        if (validarId(idEmpleado)) {
            this.idEmpleado = idEmpleado;
        } else {
            this.idEmpleado = generarId();
        }
        if (participarSorteo(idEmpleado,aniosTrabajados)) {
            JOptionPane.showMessageDialog(null, "Ha ganado el sorteo",
                    "ID de cliente: " + this.idEmpleado,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    Empleado(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public String getIdEmpleado() {
        return idEmpleado;
    }

    /**
     *
     * @param idEmpleado
     */
    public void setIdEmpleado(String idEmpleado) {
        if (validarId(idEmpleado)) {
            this.idEmpleado = idEmpleado;
        } else {
            this.idEmpleado = generarId();
        }
    }

    /**
     *
     * @return
     */
    public int getPuesto() {
        return puesto;
    }

    /**
     *
     * @param puesto
     */
    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    /**
     *
     * @return
     */
    public int getAniosTrabajados() {
        return aniosTrabajados;
    }

    /**
     *
     * @param aniosTrabajados
     * Según los años trabajados puede participar en el sorteo.
     */
    public void setAniosTrabajados(int aniosTrabajados) {
        this.aniosTrabajados = aniosTrabajados;
        if (participarSorteo(idEmpleado,aniosTrabajados)) {
            JOptionPane.showMessageDialog(null, "Ha ganado el sorteo",
                    "ID de Empleado: " + this.idEmpleado,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *
     */
    public void pedir() {
        System.out.println("Pidiendo al proveedor");
    }

    /**
     *
     */
    public void vender() {
        System.out.println("Ventas al cliente");
    }

    /**
     *
     * @param obj
     */
    public void imprimirFactura(Object obj) {
        System.out.println("Factura");
        //abrir txt con factura
    }

    /**
     *
     * @param id
     * @return
     * Valida que el id sea mayor de 5 caracteres.
     */
    @Override
    public boolean validarId(String id) {
        if (id.length()<5) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @param IdEmpleado
     * @param aniosTrabajados
     * @return
     * Participa en el sorteo al 50%
     */
    @Override
    public boolean participarSorteo(String IdEmpleado,int aniosTrabajados) {

        int var = 0;
        if (aniosTrabajados == 2) {
            var = (int) (Math.random() * 2);
        }
        if (var == 1) {
            return true;
        } else {
            return false;
        }
    }
/**
 *Compara los años trabajados de este objeto con otro.
 */
    @Override
    public int compareTo(Object o) {
        Empleado emple = (Empleado) o;
        if (this.getAniosTrabajados() < emple.getAniosTrabajados()) {
            return 1;
        } else if (this.getAniosTrabajados() > emple.getAniosTrabajados()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", puesto=" + puesto + ", aniosTrabajados=" + aniosTrabajados + '}';
    }
    
    

    /**
     *
     * @return
     * Genera un id valido de 10 digitos aletorios.
     */
    @Override
    public String generarId() {
        String id;
        StringBuffer sb = new StringBuffer();
        for (int i = 9; i >= 0; i--) {
            sb.append((int) Math.ceil(Math.random() * i));
        }
        id = sb.toString();

        return id;
    }

}
