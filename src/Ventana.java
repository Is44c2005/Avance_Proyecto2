import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JPanel Principal;
    private JSpinner spnId;
    private JTextField txtNombre;
    private JComboBox cbmEstado;
    private JButton btnRegistrar;
    private JList lstConductores;
    private JButton btnAsignar;
    private JTextField txtidAsignar;
    private JComboBox cbmPlaca;
    private JSpinner spnIdAsignar;
    private JButton btnOrdenarId;
    private JButton mostrarPorEstadoButton;
    private JComboBox cbmMostrarEstado;
    private JButton btnConductoresVehiculo;
    private JComboBox cbmConoSin;
    private JList lstvehiculos;
    private JButton btnMostrarSin;
    private JButton btnMostrarCon;
    private JButton btnCapacidad;
    Distribuidora distribuidora= new Distribuidora();


    public void llenarJlist(){
        DefaultListModel dlm= new DefaultListModel<>();
        for (Conductor c: distribuidora.getConductors()){
            dlm.addElement(c);
        }
        lstConductores.setModel(dlm);
    }
    public void llenarJlist2(){
        DefaultListModel dlm= new DefaultListModel<>();
        for (Vehiculo v: distribuidora.getVehiculos()){
            dlm.addElement(v);
        }
        lstvehiculos.setModel(dlm);
    }

    public void llenarComboVehiculos() {
        cbmPlaca.removeAllItems();
        for (Vehiculo v : distribuidora.getVehiculos()) {
            if (v.isEstado()) { // Solo mostrar disponibles
                cbmPlaca.addItem(v.getPlaca());
            }
        }
    }

    public Ventana() {
        llenarComboVehiculos();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(spnId.getValue().toString());
                String nombre= txtNombre.getText();
                if (distribuidora.buscarId(id)){
                    if (cbmEstado.getSelectedItem().toString().equals("Activo")){
                        boolean estado= true;
                        Conductor conductor= new Conductor(id,nombre, estado);
                        distribuidora.agregarConductor(conductor);
                    }else {
                        boolean estado= false;
                        Conductor conductor= new Conductor(id,nombre, estado);
                        distribuidora.agregarConductor(conductor);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Id invalido");
                }
                llenarJlist();

            }
        });
        btnAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(spnIdAsignar.getValue().toString());
                String placa = cbmPlaca.getSelectedItem().toString();

                Conductor seleccionado=null;
                Vehiculo vehiculo=null;

                for (Conductor c : distribuidora.getConductors()) {
                    if (c.getId() == id) {
                        seleccionado = c;
                        break;
                    }
                }
                if (seleccionado == null) {
                    JOptionPane.showMessageDialog(null, "Conductor no encontrado");
                    return;
                }
                for (Vehiculo v : distribuidora.getVehiculos()) {
                    if (v.getPlaca().equals(placa)) {
                        vehiculo = v;
                        break;
                    }
                }
                if (vehiculo == null) {
                    JOptionPane.showMessageDialog(null, "Vehículo no encontrado");
                    return;
                }
                seleccionado.asignarVehiculo(vehiculo);
                vehiculo.setEstado(false); // Marcarlo como ocupado


                llenarComboVehiculos();
                JOptionPane.showMessageDialog(null, "Vehículo asignado correctamente");
                llenarJlist2();
            }
        });
        btnOrdenarId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distribuidora.ordenarID();
                llenarJlist();
            }
        });
        mostrarPorEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm= new DefaultListModel<>();
                if (cbmMostrarEstado.getSelectedItem().toString().equals("Activo")){
                    for (Conductor c: distribuidora.getConductors()){
                        if (c.isEstado()){
                            dlm.addElement(c);
                        }
                    }
                }else {
                    for (Conductor c: distribuidora.getConductors()){
                        if (!c.isEstado()){
                            dlm.addElement(c);
                        }
                    }
                }
                lstConductores.setModel(dlm);
            }
        });
        btnConductoresVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm= new DefaultListModel<>();
                if (cbmConoSin.getSelectedItem().toString().equals("Con Vehículo")){
                    for (Conductor c: distribuidora.getConductors()){
                        if (c.getVehiculoAsignado() != null){
                            dlm.addElement(c);
                        }
                    }
                }else {
                    for (Conductor c: distribuidora.getConductors()){
                        if (c.getVehiculoAsignado() == null){
                            dlm.addElement(c);
                        }
                    }
                }
                lstConductores.setModel(dlm);
            }
        });
        btnMostrarSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<Vehiculo> model = new DefaultListModel<>();
                for (Vehiculo v : distribuidora.getVehiculos()) {
                    if (v.isEstado()) {
                        model.addElement(v);
                    }
                }
                lstvehiculos.setModel(model);
            }
        });
        btnMostrarCon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<Vehiculo> model = new DefaultListModel<>();
                for (Vehiculo v : distribuidora.getVehiculos()) {
                    if (!v.isEstado()) {
                        model.addElement(v);
                    }
                }
                lstvehiculos.setModel(model);
            }
        });
        btnCapacidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                distribuidora.ordenarCapacidad();
                llenarJlist2();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
