package seguimiento_programacion3.exceptions;

/**
 * @author Orlay Molina
 * PersonaNoExisteException permite indetificar al momento de crear transacciones o cuentas si el empleado
 * o cliente ya estan agregados en el programa, caso contrario informará al usuario del sistema que debe
 * crearlos primero.
 */
public class PersonaNoExisteException extends Exception {
    public PersonaNoExisteException() {
        super("El cliente no está registrado.");
    }
}
