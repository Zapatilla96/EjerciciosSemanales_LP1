package clases;

import java.io.File;                //se están importando clases necesarias para trabajar con archivos (java.io.*),
import java.sql.Connection;         // así como clases relacionadas con la conexión y manipulación de bases de datos (java.sql.*).
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LIZ
 */
public class Conexion {
    protected Connection conexion; //Aquí estamos diciendo que vamos a tener un tipo de "conexión" a una base de datos. Esta línea de código reserva un espacio para almacenar esa conexión.
    protected Statement sentencia;//estamos reservando un espacio para una "sentencia" que usaremos para hacer preguntas o realizar acciones en la base de datos.
    private String directorioData;//Esta cadena se utilizará para almacenar la ubicación (dirección) de la base de datos en tu computadora.
    private File ficheroData;//Estamos creando un tipo especial llamado File, que se utilizará para representar el archivo de la base de datos en el sistema de archivos de la computadora.
    private String rutaData;//se utilizará para almacenar la ruta completa (ubicación) de la base de datos, incluido el nombre del archivo.
                                    // rutadata : dirección relativa y directoriodata: dirección absoluta
    public Conexion() {
        rutaData = "data/BaseInventario.db"; // Paso 1: Cargar la clase JDBC de SQLite
        // Paso 2: Establecer la conexión a la base de datos
        ficheroData = new File(rutaData);
        directorioData = ficheroData.getAbsolutePath();//consigue la direccion absoluta
        // Mensaje indicando que la conexión fue exitosa
        System.out.println(directorioData);
    }
/*conectar: Intenta cargar la clase JDBC de SQLite.
Establece la conexión a la base de datos SQLite utilizando la URL que incluye la ruta del archivo.
Crea un objeto Statement a partir de la conexión.
Imprime un mensaje en la consola indicando que la conexión fue exitosa.
Captura y maneja excepciones si hay errores durante el proceso.*/
    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");//para cargar dinámicamente el controlador JDBC de SQLite. Esto le dice a Java qué implementación específica de JDBC debe utilizar para conectarse a una base de datos SQLite.
            conexion = DriverManager.getConnection("jdbc:sqlite:" + directorioData);//Usa DriverManager.getConnection("jdbc:sqlite:" + directorioData); para establecer la conexión a la base de datos SQLite. La URL JDBC especifica el tipo de base de datos y la ruta del archivo de la base de datos.
            sentencia = conexion.createStatement();// crea un objeto Statement que se puede utilizar para ejecutar consultas SQL en la base de datos.
            System.out.println("Conectado a SQlite.!");
        } catch (ClassNotFoundException | SQLException ex) { //En caso de que se produzca una excepción (por ejemplo, si la clase del controlador no se encuentra o hay un error al conectarse), se imprime un mensaje de error. Esta parte es importante para el manejo de errores y para saber qué salió mal en caso de problemas.
            System.err.println("Error en: " + ex);
        }
    }
//este método devuelve la conexión a la base de datos y está diseñado para ser utilizado externamente para obtener acceso a la conexión
    public Connection retornarConexion() {
        Connection conex = null;//Se inicializa una variable de tipo Connection llamada conex y se establece inicialmente en null. Esta variable se utilizará para almacenar la conexión y se devolverá al final del método.
        try {
            conectar(); //Se llama al método conectar() para asegurar que la conexión esté establecida antes de intentar devolverla. Esto garantiza que la conexión esté lista para ser utilizada.
            conex = sentencia.getConnection();//Después de llamar al método conectar(), la conexión establecida se asigna a la variable conex.
           
        } catch (SQLException ex) {
            System.err.println("Error en: " + ex);//n caso de que se produzca una excepción (por ejemplo, si hay un error al conectar), se imprime un mensaje de error. Esto es importante para el manejo de errores y para saber qué salió mal en caso de problemas.
        }
        return conex;//Se devuelve la variable conex, que contiene la conexión establecida. Puede ser null si ocurrió un error durante el proceso de conexión.
    //Este método permite obtener la conexión a la base de datos desde fuera de la clase Conexion. Al llamar a este método, se obtiene acceso a la conexión ya establecida y lista para su uso en operaciones con la base de datos SQLite.
    }
}
