public class Conductor {
    private int id;
    private String nombre;
    private boolean estado;
    private Vehiculo vehiculoAsignado;

    public Conductor(int id, String nombre, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.vehiculoAsignado = null;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public void asignarVehiculo(Vehiculo v){
        this.vehiculoAsignado = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public void cambiarEstado(boolean estado){

    }

    public void mostrarDetalles(){

    }


    @Override
    public String toString() {
        return "Conductor{" +
                "id=" + id +
                ", nombre='" + nombre + '\n' +
                ", estado=" + estado ;
    }
}
