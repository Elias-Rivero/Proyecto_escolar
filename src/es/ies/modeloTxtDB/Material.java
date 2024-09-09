package es.ies.modeloTxtDB;

public class Material {
    private final int id;
    private final String nombre;
    private final double peso;
    private final String dimensiones;
    private final double precio;
    private final String tiempoEntrega;
    private final int cantidadDisponible;

    public Material(int id, String nombre, double peso, String dimensiones, double precio, String tiempoEntrega,
            int cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.precio = precio;
        this.tiempoEntrega = tiempoEntrega;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Obtener id
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTiempoEntrega() {
        return tiempoEntrega;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + peso + "," + dimensiones + "," + precio + "," + tiempoEntrega + ","
                + cantidadDisponible;
    }
}
