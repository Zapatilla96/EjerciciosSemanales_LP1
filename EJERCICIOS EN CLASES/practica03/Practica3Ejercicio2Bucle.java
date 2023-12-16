import java.util.Scanner;

/**
 * Practica3Ejercicio2Bucle - FOR2
 */
public class Practica3Ejercicio2Bucle {
public static void main(String[] args) {
    Scanner scanner = new Scanner (System.in);
    int tabla, resultado;
    System.out.print("que tabla desea mostrar?: ");
    tabla = scanner.nextInt();
    for (int i = 1; i < 11; i++) {
        resultado = tabla*i;
        System.out.println(i + "x" + tabla + "=" + resultado);
    scanner.close();
    }
}
    
}