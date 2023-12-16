/**
 * Cliente
 */
public class Cliente {

    private String nombre;
    private int monto;

    //constructor
    public Cliente(String nombre){ //va a recibir un parametro
        this.nombre = nombre; //this para referirse al nombre de la clase es igual al nombre que se va a recibir
        this.monto = 0;
    }

    public void depositar(int monto){

        this.monto= this.monto + monto;

    }
    public void extraer(int monto){

        this.monto= this.monto - monto;
        
    }
    public int retornarMonto(){
        return this.monto;
    }
    public String retornarNombre(){
        return this.nombre;
    }

    
}
