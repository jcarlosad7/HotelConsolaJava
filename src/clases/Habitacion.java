package clases;

public class Habitacion {
    private int id;
    private int numero;
    private double precio;
    private boolean estado;
    private String descripcion;
    //Constructor
    public Habitacion(){

    }

    public Habitacion(int id, int numero, double precio, boolean estado, String descripcion) {
        this.id = id;
        this.numero = numero;
        this.precio = precio;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    //Métodos setter y getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
