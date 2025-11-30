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
    Distribuidora distribuidora= new Distribuidora();


    public void llenarJlist(){
        DefaultListModel dlm= new DefaultListModel<>();
        for (Conductor c: distribuidora.getConductors()){
            dlm.addElement(c);
        }
        lstConductores.setModel(dlm);
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
                    llenarJlist();
                }else {
                    JOptionPane.showMessageDialog(null,"Id invalido");
                }

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

                llenarJlist();
                llenarComboVehiculos();
                JOptionPane.showMessageDialog(null, "Vehículo asignado correctamente");
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
