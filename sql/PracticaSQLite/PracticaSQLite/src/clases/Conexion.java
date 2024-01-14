package clases;

import java.io.*;
import java.sql.*;

/**
 *
 * @author joare
 */
public class Conexion {

    protected Connection conexion;
    protected Statement sentencia;
    private String directorioData;
    private File ficheroData;
    private String rutaData;

    public Conexion() {
        rutaData = "data/demolite.db";
        ficheroData = new File(rutaData);
        directorioData = ficheroData.getAbsolutePath();
        System.out.println(directorioData);
    }

    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + directorioData);
            sentencia = conexion.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error en: " + ex);
        }
    }

    public Connection retornarConexion() {
        Connection conex = null;
        try {
            conectar();
            conex = sentencia.getConnection();
        } catch (SQLException ex) {
            System.err.println("Error en: " + ex);
        }
        return conex;
    }
}
