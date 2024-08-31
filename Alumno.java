package actividad_semana_7;

import static java.lang.System.out;

import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

/**
 * Clase encargada de la lógica del alumno
 */
public class Alumno implements Serializable {
    private String nombre;
    private Float nota1;
    private Float nota2;
    private Float nota3;

    Alumno( String nuevoNombre ) {
        this.nombre = nuevoNombre;
    }

    public String getName() {
        return this.nombre;
    }

    public String getPromedio() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(2);

        return String.valueOf(
            formatter.format( (this.nota1 * 0.3 )+(this.nota2*0.3)+(this.nota3*0.4) )
        );
    }

    public Float setNota(String note, Integer idx) {
        try {
            Float value = Float.parseFloat(note);
            if(value > 5 || value < 0 ) {
                throw new IOException("el valor ingresado debe ser menor/igual a 5.0 y mayor/igual a 0");
            }

            switch (idx) {
                case 1:
                    return this.nota1 = value;
                case 2:
                    return this.nota2 = value;
                case 3:
                    return this.nota3 = value;
                default:
                    return null;
            }
        } catch(NumberFormatException ioException) {
            out.println("valor incorrecto: {1} no es un número"
                .replace("{1}", note)
            );
            return null;
        } catch(IOException ioException) {
            out.println(ioException.getMessage());
            return null;
        }
    }

}
