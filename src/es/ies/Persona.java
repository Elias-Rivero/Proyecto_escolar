
package es.ies;

public abstract class Persona  {

    private String nombre;
    private String direccion;
    private String telefono;
    static int contador = 0;

    public Persona() {
        contador++;
    }

    public Persona(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        contador++;
        if (!validarTelefono(telefono)) {
            System.out.println("Telefono incorrecto");
        }
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getContador() {
        return contador;
    }

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

    public abstract boolean validarId(String id);

    public abstract String generarId();

}
