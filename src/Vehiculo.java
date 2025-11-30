public class Vehiculo {
    private String placa;
    private double capacidadMax;
    private boolean estado; // true = disponible, false = ocupado

    public Vehiculo(String placa, double capacidadMax, boolean estado) {
        this.placa = placa;
        this.capacidadMax = capacidadMax;
        this.estado = estado;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(double capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\n' +
                ", capacidadMax=" + capacidadMax +
                ", estado=" + estado ;
    }
}
