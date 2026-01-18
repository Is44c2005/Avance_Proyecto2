public class Producto {
    private int id;
    private String nombre;
    private double peso;
    private double precio;

    public Producto(int id, String nombre, double peso, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecio() {
        return precio;
    }

    // Costo base de envío (ejemplo simple)
    public double calcularCostoEnvio() {
        return peso * 0.5;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " | $" + precio + " | " + peso + "kg";
    }
}
