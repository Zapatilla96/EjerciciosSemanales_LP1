import java.util.Scanner;
//Practica2Ejercicio1Condicional

public class Practica2Ejercicio1Condicional{
static String red ="\033[31m";  //se fuera de main para que se pueda usar de forma global, las variables definidas en main solo se pueden usar en la clase main.
static String green ="\033[32m";
static String reset ="\u001B[0m";
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        //variable: definir 
        float ingreso;
        float irp = 80000000;
        //entrada
        System.out.print(reset + "Digite el ingreso anual: "); //IMPRIME EN PANTALLA CON SALTO DE LINEA POR (ln) despues del print
        ingreso=scanner.nextFloat(); //Para capturar el dato ingresado de tipo float
        //condicion
        if(ingreso > irp){
            System.out.println(red + "Debe abonar IRP el siguiente año ");//se concatenea las lineas 3,4 y 5 para que el texto salga de ese color
        }else{
            System.out.println(green + "No abona IRP");
        }

      scanner.close();//para que el scaner no subraye en amarillo  
      System.out.print(reset); //solo imprime el color del sistem, para que el color no quede con los que se puso en la linea 16 y 18
    }
}