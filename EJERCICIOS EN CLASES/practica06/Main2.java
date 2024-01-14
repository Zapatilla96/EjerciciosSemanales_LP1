public class Main2 {
    private int atributo1;
    private int atributo2;
    private String atributo3;
    public Main2(int attr1, int attr2, String attr3)
    {
        atributo1= attr1;
        atributo2= attr2;
        atributo3=attr3;
    }
    public static void main(String[] args) {
        Main2 ac = new Main2(5,10,"x");
        System.out.println(ac.atributo1 + ", " +  ac.atributo2 + ", " + ac.atributo3);
    }
}
