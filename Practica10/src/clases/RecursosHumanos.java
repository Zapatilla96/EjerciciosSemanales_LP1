package clases;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RecursosHumanos {
String CodigoRRHH;
String NombreyApellido;
String Cargo;
String Especialidad;

    public String getCodigoRRHH() {
        return CodigoRRHH;
    }

    public void setCodigoRRHH(String CodigoRRHH) {
        this.CodigoRRHH = CodigoRRHH;
    }

    public String getNombreyApellido() {
        return NombreyApellido;
    }

    public void setNombreyApellido(String NombreyApellido) {
        this.NombreyApellido = NombreyApellido;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

public void agregarRegistrosCompras() {
	try {
		FileWriter fw = new FileWriter("RRHH.txt",true);

		
		fw.write(getCodigoRRHH());
		fw.write(",");
		fw.write(getNombreyApellido());
		fw.write(",");
		fw.write(getCargo());
                fw.write(",");
		fw.write(getEspecialidad());
		fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registro correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un error al registrar" + e.toString());
	}
}
    public void crearArchivoCompras() {
	try {
		File objetoArchivo = new File("RRHH.txt");
		if(objetoArchivo.createNewFile()) {
			JOptionPane.showMessageDialog(null,"Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
		}
		else {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		}
		
	} catch (Exception e) {
		System.out.println("Ocurrió un error al crear el archivo");
		
	}
    }
    public void MostrarTotalCompras(JTable tbListaRecursosHumanos) {
	
	String nombreArchivo = "RRHH.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
              
		model.addColumn("Codigo");
		model.addColumn("NombreyApellido");
		model.addColumn("Cargo");
                model.addColumn("Especialidad");
		
		tbListaRecursosHumanos.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tbListaRecursosHumanos.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}
    public void seleccionarCompras(JTable tbListaRecursosHumanos) {
	
	try {
		
		int  fila = tbListaRecursosHumanos.getSelectedRow();
		
		if (fila>=0) {
					 /*String CodigoRRHH;
String NombreyApellido;
String Cargo;
String Especialidad;*/ 
			setCodigoRRHH(tbListaRecursosHumanos.getValueAt(fila, 0).toString());
			setNombreyApellido(tbListaRecursosHumanos.getValueAt(fila, 1).toString());
			setCargo(tbListaRecursosHumanos.getValueAt(fila, 2).toString());
                        setEspecialidad(tbListaRecursosHumanos.getValueAt(fila, 3).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}
    public void EditarCompras(JTable tbListaRecursosHumanos) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("RRHH.txt");
			writer.print("");
			writer.close();
        		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminaci�n
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RRHH.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tbListaRecursosHumanos.getColumnCount(); col++) {
				joiner.add(tbListaRecursosHumanos.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tbListaRecursosHumanos.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tbListaRecursosHumanos.getColumnCount(); col++) {
					
					Object obj = tbListaRecursosHumanos.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);
					
				}
				
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
				//JOptionPane.showMessageDialog(null, "Se modific� correctamente");
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error");
		}
		
}
public void EliminarCompras (JTable tbListaRecursosHumanos, JTextField CodigoRRHH) {
	
	//Eliminaci�n visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tbListaRecursosHumanos.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(CodigoRRHH.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("RRHH.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminaci�n
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RRHH.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tbListaRecursosHumanos.getColumnCount(); col++) {
			joiner.add(tbListaRecursosHumanos.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tbListaRecursosHumanos.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tbListaRecursosHumanos.getColumnCount(); col++) {
				
				Object obj = tbListaRecursosHumanos.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se elimino correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}

}
