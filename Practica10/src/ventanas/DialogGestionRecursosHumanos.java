package ventanas;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;


public class DialogGestionRecursosHumanos extends JDialog {
        private JTextField txtCodigoRRHH;
	private JTextField txtNombreyApellido;
	private JTextField txtCargo;
        private JTextField txtEspecialidad;
	private JTable tbListaRecursosHumanos;
        public static void main(String[] args) {
		try {
			DialogGestionRecursosHumanos dialog = new DialogGestionRecursosHumanos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        public DialogGestionRecursosHumanos() {
                setTitle("GESTION DE RECURSOS HUMANOS");
		setBounds(100, 200, 633, 343);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 239, 244);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtCodigoRRHH = new JTextField();
		txtCodigoRRHH.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoRRHH);
		txtCodigoRRHH.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 27, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre y Apellido");
		lblNewLabel_4.setBounds(10, 68, 108, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cargo");
		lblNewLabel_5.setBounds(10, 103, 46, 14);
		panel.add(lblNewLabel_5);
                
                JLabel lblNewLabel_6 = new JLabel("Especialidad");
		lblNewLabel_6.setBounds(10, 140, 78, 14);
		panel.add(lblNewLabel_6);

		
		txtNombreyApellido = new JTextField();
		txtNombreyApellido.setBounds(132, 65, 86, 20);
		panel.add(txtNombreyApellido);
		txtNombreyApellido.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(132, 103, 86, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
                
                txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(132, 140, 86, 20);
		panel.add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.setCodigoRRHH(txtCodigoRRHH.getText());
				objetoRecursosHumanos.setNombreyApellido(txtNombreyApellido.getText());
				objetoRecursosHumanos.setCargo(txtCargo.getText());
                                objetoRecursosHumanos.setEspecialidad(txtEspecialidad.getText());
				objetoRecursosHumanos.agregarRegistrosCompras();
			}
		});
		btnGuardar.setBounds(10, 180, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.EditarCompras(tbListaRecursosHumanos);
			}
		});
		btnEditar.setBounds(109, 180, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.EliminarCompras(tbListaRecursosHumanos, txtCodigoRRHH);
			}
		});
		btnEliminar.setBounds(10, 208, 208, 29);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de Recursos Humanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 244);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 206);
		panel_1.add(scrollPane);
		
		tbListaRecursosHumanos = new JTable();
		scrollPane.setViewportView(tbListaRecursosHumanos);
		
		JButton btnCrearArchivoRRHH = new JButton("Crear Archivo RRHH");
		btnCrearArchivoRRHH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos= new clases.RecursosHumanos();
				objetoRecursosHumanos.crearArchivoCompras();
			}
		});
		btnCrearArchivoRRHH.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoRRHH);
		
		JButton btnMostrarListaRecursosHumanos = new JButton("Mostrar Lista RRHH");
		btnMostrarListaRecursosHumanos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.MostrarTotalCompras(tbListaRecursosHumanos);
			}
		});
		btnMostrarListaRecursosHumanos.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarListaRecursosHumanos);
		
		JButton btnSeleccionar = new JButton("Seleccionar Empleado");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
                		/*private JTextField txtCodigoRRHH;
	private JTextField txtNombreyApellido;
	private JTextField txtCargo;
        private JTextField txtEspecialidad;
	private JTable tbListaRecursosHumanos;*/
				objetoRecursosHumanos.seleccionarCompras(tbListaRecursosHumanos);
				txtCodigoRRHH.setText(objetoRecursosHumanos.getCodigoRRHH());
				txtNombreyApellido.setText(objetoRecursosHumanos.getNombreyApellido());
				txtCargo.setText(objetoRecursosHumanos.getCargo());
                                txtEspecialidad.setText(objetoRecursosHumanos.getEspecialidad());
			}
		});
		btnSeleccionar.setBounds(433, 21, 181, 23);
		getContentPane().add(btnSeleccionar);
	}
 
  
}
