/**
 * Parcial_LP1
 */
public class Main {

    public String metodoString(int n)
    {
        if (n==0) {
            return "a";
        }
        return "x";
    }
    public static void main(String[] args) {
        Main principal = new Main();
        System.out.println(principal.metodoString(2023));
    }
}