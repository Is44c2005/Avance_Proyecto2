import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private String nombre;
    private List<Conductor> conductors;
    private List<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public Distribuidora (){
        conductors =new ArrayList<Conductor>();
        vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(new Vehiculo("ABC-1234", 2000, true));
        vehiculos.add(new Vehiculo("XYZ-5678", 3500, true));
        vehiculos.add(new Vehiculo("MNO-9012", 1500, true));
    }


    public boolean buscarId(int id) {
        for (Conductor c : conductors) {
            if (c.getId() == id) {
                return false;
            }
        }
        return true;
    }

    public void ordenarID (){
        Conductor aux;

        for (int i=0;i<conductors.size()-1;i++){
            for (int j=i+1;j<conductors.size();j++){
                if (conductors.get(i).getId()>conductors.get(j).getId()){
                    aux = conductors.get(i);
                    conductors.set(i,conductors.get(j));
                    conductors.set(j,aux);
                }
            }
        }
    }

    public void ordenarCapacidad (){
        Vehiculo aux;

        for (int i=0;i<vehiculos.size()-1;i++){
            for (int j=i+1;j<vehiculos.size();j++){
                if (vehiculos.get(i).getCapacidadMax()>vehiculos.get(j).getCapacidadMax()){
                    aux = vehiculos.get(i);
                    vehiculos.set(i,vehiculos.get(j));
                    vehiculos.set(j,aux);
                }
            }
        }
    }



    public void agregarConductor(Conductor c){
        conductors.add(c);
    }

    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Conductor> getConductors() {
        return conductors;
    }

    public void setConductors(List<Conductor> conductors) {
        this.conductors = conductors;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
