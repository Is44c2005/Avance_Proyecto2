import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public List<ArrayList<Pedido>> getPedidos() {
        return Collections.singletonList(pedidos);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }

}
