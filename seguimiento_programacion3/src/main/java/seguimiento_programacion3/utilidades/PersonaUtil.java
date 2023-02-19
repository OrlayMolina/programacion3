package seguimiento_programacion3.utilidades;

import seguimiento_programacion3.personas.Persona;

import java.util.function.Predicate;

public class PersonaUtil {

    public static Predicate<Persona> buscarPorNumeroIdentificacion(String numeroIdentificacion) {
            return persona -> persona.getNumeroDocumento().equals(numeroIdentificacion);
    }

    public static Predicate<Persona> buscarPorPrimerNombre(String primerNombre) {
        return persona -> persona.getPrimerNombre().contains(primerNombre);
    }

    public static Predicate<Persona> buscarPorSegundoNombre(String segundoNombre) {
        return persona -> persona.getSegundoNombre().contains(segundoNombre);
    }

    public static Predicate<Persona> buscarPorPrimerApellido(String primerApellido) {
        return persona -> persona.getPrimerApellido().contains(primerApellido);
    }

    public static Predicate<Persona> buscarPorSegundoApellido(String segundoApellido) {
        return persona -> persona.getSegundoApellido().contains(segundoApellido);
    }

    public static Predicate<Persona> buscarPorDireccion(String direccion) {
        return persona -> persona.getDireccion().contains(direccion);
    }

    public static Predicate<Persona> buscarPorCorreo(String correo) {
        return persona -> persona.getCorreo().contains(correo);
    }

    public static Predicate<Persona> buscarPorTodo(String numeroDocumento, String primerNombre, String segundoNombre,
                                                   String primerApellido, String segundoApellido, String direccion, String correo) {
        Predicate<Persona> predicado = persona -> true;
        if (numeroDocumento != null && !numeroDocumento.isEmpty()) {
            predicado = predicado.and(buscarPorNumeroIdentificacion(numeroDocumento));
        }
        if (primerNombre != null && !primerNombre.isEmpty()) {
            predicado = predicado.and(buscarPorPrimerNombre(primerNombre));
        }
        if (segundoNombre != null && !segundoNombre.isEmpty()) {
            predicado = predicado.and(buscarPorSegundoNombre(segundoNombre));
        }
        if (primerApellido != null && !primerApellido.isEmpty()) {
            predicado = predicado.and(buscarPorPrimerApellido(primerApellido));
        }
        if (segundoApellido != null && !segundoApellido.isEmpty()) {
            predicado = predicado.and(buscarPorSegundoApellido(segundoApellido));
        }
        if (direccion != null && !direccion.isEmpty()) {
            predicado = predicado.and(buscarPorDireccion(direccion));
        }
        if (correo != null && !correo.isEmpty()) {
            predicado = predicado.and(buscarPorCorreo(correo));
        }
        return predicado;
    }
}
