import java.util.ArrayList;
import java.util.List;

public class Pedido extends ArrayList<Pedido> {
    private int id;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // MÉTODO CLAVE: agregar producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Calcular total del pedido
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    // Calcular peso total
    public double calcularPesoTotal() {
        double peso = 0;
        for (Producto p : productos) {
            peso += p.getPeso();
        }
        return peso;
    }

    @Override
    public String toString() {
        return "Pedido " + id +
                " | Cliente: " + cliente.getNombre() +
                " | Total: $" + calcularTotal();
    }

    @Override
    public List<Pedido> reversed() {
        return super.reversed();
    }
}
