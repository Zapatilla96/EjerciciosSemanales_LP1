package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LIZ
 */
public class Controlador extends Conexion{
    
      ResultSet resultado = null;

    
    public Controlador() {
    }

    public void desconectar() {
        System.out.println("SQLite desconectado...!");
        try {
            sentencia.close();
            conexion.close();
        } catch (SQLException ex) {
            reportarError(ex);
        }
    }

    public void reportarError(SQLException ex) {
        System.err.println("ERROR ACTUALIZANDO: " + ex);
    }

    public void imprimirSQL(String sql) {
        System.err.println(sql);
    }

    public boolean actualizar(String cadenaSQL) {
        //INSERT INTO  //UPDATE    //DELETE FROM
        boolean valor = true;
        conectar();
        try {
            imprimirSQL(cadenaSQL);
            sentencia.executeUpdate(cadenaSQL);
        } catch (SQLException ex) {
            reportarError(ex);
            valor = false;
        }
        desconectar();
        return valor;
    }

    public ResultSet consultar(String cadenaSQL) {
        //SELECT
        resultado = null;
        conectar();
        try {
            resultado = sentencia.executeQuery(cadenaSQL);
            imprimirSQL(cadenaSQL);
        } catch (SQLException ex) {
            reportarError(ex);
        }
        return resultado;
    }

    public int generarCodigo(String objeto, String id) {
        int codigo = 1;
        resultado = null;
        String cadenaSQL = "SELECT MAX(" + id + ") FROM " + objeto;
        try {
            resultado = consultar(cadenaSQL);
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            reportarError(ex);
        }
        desconectar();
        return codigo;
    }

    public void cargarJTable(DefaultTableModel tablaAuxiliar, String cadenaSQL) {
        resultado = null;
        tablaAuxiliar.setRowCount(0);
        tablaAuxiliar.setColumnCount(0);
        try {
            resultado = consultar(cadenaSQL);
            if (resultado != null) {
                int nCol = resultado.getMetaData().getColumnCount();
                for (int n = 1; n <= nCol; n++) { //nombre de columnas
                    tablaAuxiliar.addColumn(resultado.getMetaData().getColumnName(n).toUpperCase());
                }
                while (resultado.next()) {
                    Object[] fila = new Object[nCol];
                    for (int o = 1; o <= nCol; o++) { //agregando filas encontradas
                        fila[o - 1] = resultado.getObject(o);
                    }
                    tablaAuxiliar.addRow(fila);
                }
            }
        } catch (SQLException ex) {
            reportarError(ex);
        }
        desconectar();
    }
    public void verificar(){
        System.out.println("hola");
    }
}
    

