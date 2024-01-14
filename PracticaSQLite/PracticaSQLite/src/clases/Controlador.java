package clases;

/**
 *
 * @author Jorge Arevalos
 */
import java.sql.*;

public class Controlador extends Conexion {

    ResultSet resultado = null;

    //constructor
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
    public void imprimirSQL(String sql){
        System.err.println(sql);

}

    public boolean actualizar(String cadenaSQL) {
        //INSERT INTO  //UPDATE    //DELETE FROM
        boolean valor = true;
        //conectanos a la base de datos
        conectar();
        try {
            sentencia.executeUpdate(cadenaSQL);
            imprimirSQL(cadenaSQL);
        } catch (SQLException ex) {
            reportarError(ex);
            valor = false;
        }
        desconectar();
        return valor;
    }

    public ResultSet consultar(String cadenaSQL) {
        //SELECT //consulta
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
        resultado = consultar(cadenaSQL);
        try {
            if (resultado.next()) {
                codigo = resultado.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            reportarError(ex);
        }
        return codigo;
    }
}
