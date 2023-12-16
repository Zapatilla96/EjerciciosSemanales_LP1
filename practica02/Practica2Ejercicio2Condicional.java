import java.util.Scanner;//para poder utilizar el escaner de teclado

public class Practica2Ejercicio2Condicional {

    
    public static void main(String[] args) {

        //variables
        Scanner scanner = new Scanner(System.in); //habilita un nuevo escaner con el nombre scanner
        int num1, num2; //se definen las variables de tipo entero
        //entrada
        System.out.print("Digite primer numero: ");//solicita introduccion de datos al usuario
        num1 = scanner.nextInt();//recopila lo introducido por medio del teclado y lo guarda en la variable
        System.out.print("Digite segundo numero: ");
        num2 = scanner.nextInt();
        //condicional
        if(num1>num2){
            System.out.print("primer numero es mayor: ");
        }else if(num1<num2){ //para plantear una segunda condicion sin cerrar con else directamente
            System.out.print("segundo numero es mayor:  ");
        }else{
            System.out.print("ambos numeros son iguales: ");
        }
        scanner.close();
    }
   
    
}
