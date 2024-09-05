
package es.ies;


/**
 *
 * @author Jorge
 */
public abstract class Persona  {

    private String nombre;
    private String direccion;
    private String telefono;
    static int contador = 0;

    /**
     *
     */
    public Persona() {
        contador++;
    }

    /**
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * En el constructor valida el telefono.
     */
    public Persona(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        contador++;
        if (!validarTelefono(telefono)) {
            System.out.println("Telefono incorrecto");
        }
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public int getContador() {
        return contador;
    }

    /**
     *
     * @param telefono
     * @return
     * Comprueba que tenga 9 digitos.
     */
    public final boolean validarTelefono(String telefono) {
        int cont = 0;

        for (int i = 0; i < telefono.length(); i++) {
            if (Character.isDigit(telefono.charAt(i))) {
                cont++;
            }else{
                System.out.println("valor incorrecto en telefono");
                return false;
            }
        }
        if (cont == 9) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public abstract boolean validarId(String id);

    /**
     *
     * @return
     */
    public abstract String generarId();

}
