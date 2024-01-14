package clases;

/**
 *
 * @author Jorge Arevalos
 */
public class ComboBoxT {

    private String id;
    private String nombre;
    private String precio;

    public ComboBoxT() {
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
