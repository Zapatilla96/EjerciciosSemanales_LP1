/**
 * @LizDominguez
 * Persona
 */
public class Persona {
private String nombre;
private int edad;
public Persona(String nombre, int edad){

    this.nombre=nombre;
    this.edad=edad;

}
    public String getNombre(){ return this.nombre;}
    public String toString(){ return "Nombre" + this.nombre + "Edad" + this.edad;}
    public void MostrarDatos(){
        System.out.println("Nombre: " + nombre);
    }
}
 