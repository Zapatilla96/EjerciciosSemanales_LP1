import java.util.Scanner;

/**
 * Persona
 * clases son objetos (puede ser del mundo real, persona, objeto, cosas)
 * metodos: para alterar caracteristicas de un objeto
 *      publico: cambio de valores dentro de la clase, se puede acceder desde otra clase
 *      private: solo en la clase, se puede alterar con un metodo.
 *      protected:
 * 
 */
public class Persona {
    private Scanner scanner; //private: variables o atributos solo utilizables dentro de la clase.
    private String nombre;
    private int edad;
    
    public void inicializar(){ //metodo
        scanner = new Scanner (System.in);
        System.out.print("Ingrese nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Digite edad: ");
        edad = scanner.nextInt();


    }
    public void imprimir(){
        System.out.println("El nombre ingresado fue "+ nombre);
        System.out.println("La edad ingresada fue " + edad);
    }
    public void burcarMayor(){//Mayoria de edad
        if (edad>=18) {
            System.out.println(nombre + "Es mayor de edad");
        }else{
            System.out.println(nombre + "Es menor de edad");
        }
    }


    public static void main(String[] args) {
        Persona persona = new Persona(); //Esto se define como instanciar. Es como crear un nuevo objeto especifico de un objeto/clase/plantila, con caracteristicas especificas gracias a los metodos
        persona.inicializar();
        persona.imprimir();
        persona.burcarMayor();
    }


    
}