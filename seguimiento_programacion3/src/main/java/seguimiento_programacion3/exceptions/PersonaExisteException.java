package seguimiento_programacion3.exceptions;

/**
 * @author Orlay Molina
 * Función PersonaExisteExceiption valida dentro de las listas de los tipos de personas (empleados y cliente), sí
 * estos ya se encuentran agregados en el listado.
 */
public class PersonaExisteException extends Exception {
    public PersonaExisteException() {
        super("El cliente ya está registrado.");
    }
}
