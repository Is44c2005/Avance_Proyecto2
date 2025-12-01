import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private String nombre;
    private List<Conductor> conductors;
    private List<Vehiculo> vehiculos;

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
