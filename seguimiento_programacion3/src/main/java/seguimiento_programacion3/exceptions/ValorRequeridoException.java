package seguimiento_programacion3.exceptions;

/**
 * @author Orlay Molina
 * Función ValorRequeridoException solicitará aquellos datos que sean de carácter obligatorio dentro del programa.
 */
public class ValorRequeridoException extends Exception {
    public ValorRequeridoException(String nombre) {
        super(String.format("El %s es requerido", nombre));
    }
}