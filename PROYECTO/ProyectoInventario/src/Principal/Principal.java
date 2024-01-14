package Principal;
import clases.Conexion;
import clases.Controlador;

/**
 *
 * @author LIZ
 */
public class Principal {

    public Principal(){

    }
    public static void main(String[] args) {
        // TODO code application logic here
     
    Conexion coneccion = new Conexion();
    coneccion.conectar();
    coneccion.retornarConexion();
    Controlador controlador = new Controlador();
    controlador.verificar();
    
    
    }

    
}
