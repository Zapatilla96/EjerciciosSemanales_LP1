package clases;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jorge Arevalos
 */
public class Funciones {

    public void mayuscula(KeyEvent x) {
        char c = x.getKeyChar();
        String cc = (String.valueOf(c)).toUpperCase();
        c = cc.charAt(0);
        x.setKeyChar(c);
    }
    
     public String convertirFecha(JDateChooser fechaFormulario) {
        return String.valueOf(fechaFormulario.getDate().getDate())
                + "/" + String.valueOf(fechaFormulario.getDate().getMonth() + 1)
                + "/" + String.valueOf(fechaFormulario.getDate().getYear() + 1900);
    }

}
