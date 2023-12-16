import java.util.Scanner;

/**
 * Practica3Ejercicio4BucleW
 * @autor LIZ DOMINGUEZ
 */
public class Practica3Ejercicio4BucleW {

    public static void main(String[] args) {
        //variables
        Scanner scanner = new Scanner(System.in);
        String usuario;
        String usuarioCorrecto = "admin";
        int pin;
        int pinCorrecto = 1234567;
        int correcto = 0;
        while (correcto == 0) 
        {
            //entrada
            System.out.print("Ingrese Usuario: ");
            usuario = scanner.nextLine();
            System.out.println("");
            System.out.print("Ingrese pin: ");
            pin = scanner.nextInt();
            
            // verificar : para comparar string se usa equals
                if ((usuario.equals(usuarioCorrecto)) && (pin==pinCorrecto)) 
                {
                    correcto = 1;
                }else{System.out.println("Usuario y/o pin incorrecto");}
        
        scanner.nextLine(); //el escaner no captura string luego de capturar entero, con esto se resetea y vuelve a capturar string.
        }
        System.out.println("Bienvenido");
        scanner.close();
    }
    
}