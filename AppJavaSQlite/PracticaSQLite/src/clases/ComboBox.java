package clases;

/**
 *
 * @author Jorge Arevalos
 */
public class ComboBox {

    private String id;
    private String nombre;

    public ComboBox() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
