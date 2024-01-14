import java.util.Scanner;

/**
 * CicloWhile
 */
public class CicloWhile {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
               int numero= sc.nextInt();
        
        while (numero <= 500) {
            System.out.println("Ingrese un numero");
           numero = sc.nextInt();
        }
    }
}