package seguimiento_programacion3.personas;

import seguimiento_programacion3.exceptions.ValorRequeridoException;

import java.util.Objects;

/**
 * @author Orlay Molina
 * @version 1.0
 * @since February 2023
 * Se crea la clase Persona que contiene los campos necesarios para la instanciación de cada persona
 * dentro del sistema.
 */
public class Persona {

    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String correo;

    public Persona(){

    }

    /**
     * Constructor de la clase persona el cuál recibe como parametros los siguientes satoas básicos.
     * @param numeroDocumento
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @param direccion
     * @param correo
     */
    public Persona(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido,
                   String segundoApellido, String direccion, String correo) {
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.correo = correo;
    }

    /**
     * @return Retorna una persona una vez sean validados los campos requeridos como minímo en la instanciación
     * de una nueva persona dentro del programa.
     * @param numeroIdentificacion
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @param direccion
     * @param correo
     * @return
     * @throws ValorRequeridoException que se encuentra detallado en el package exceptions en donde se
     * indican las validaciones necesarias al recibir los datos que ingresa el usuario.
     */
    public static Persona of(String numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
                             String direccion, String correo) throws ValorRequeridoException {
        if (Objects.requireNonNull(primerNombre, "El primer nombre es requerido").isEmpty()) {
            throw new ValorRequeridoException(" primer nombre");
        }

        if (Objects.requireNonNull(numeroIdentificacion, "El número de identificación es requerido").isEmpty()) {
            throw new ValorRequeridoException("número de identificación");
        }
        if (Objects.requireNonNull(primerApellido, "El apellido es requerido").isEmpty()) {
            throw new ValorRequeridoException("primer apellido");
        }

        if (Objects.requireNonNull(direccion, "La dirección es requerido").isEmpty()) {
            throw new ValorRequeridoException("dirección");
        }
        if (Objects.requireNonNull(correo, "El correo es requerido").isEmpty()) {
            throw new ValorRequeridoException("correo");
        }
        return new Persona(numeroIdentificacion,
                primerNombre, segundoNombre, primerApellido, segundoApellido, direccion, correo);
    }

    /**
     * se crean los métodos gettes and setters de la aplicación para mantener el encapsulamientos de los datos.
     * @return getters
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) throws Exception {

        if (numeroDocumento.matches("[!-@]*")) {
            throw new Exception("El número de documento no puede contener carácteres especiales.");
        }

        if (numeroDocumento.matches("[A-z]*")) {
            throw new Exception("El tipo de documento cédula no puede contener letras.");
        }

        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) throws Exception{

        if (primerNombre.matches("[0-9]*")) {
            throw new Exception("El primer nombre no puede contener números.");
        }
        if (primerNombre.matches("[!-@]*")) {
            throw new Exception("El primer nombre no puede contener caracteres especiales.");
        }
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) throws Exception{
        if (segundoNombre.matches("[0-9]*")) {
            throw new Exception("El segundo nombre no puede contener números");
        }
        if (segundoNombre.matches("[!-@]*")) {
            throw new Exception("El segundo nombre no puede contener caracteres especiales");
        }
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) throws Exception {
        if (primerApellido.matches("[0-9]*")) {
            throw new Exception("El primer apellido no puede contener números");
        }
        if (primerApellido.matches("[!-@]*")) {
            throw new Exception("El primer apellido no puede contener caracteres especiales");
        }
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) throws Exception{
        if (segundoApellido.matches("[0-9]*")) {
            throw new Exception("El segundo apellido no puede contener números");
        }
        if (segundoApellido.matches("[!-@]*")) {
            throw new Exception("El segundo apellido no puede contener caracteres especiales");
        }
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}