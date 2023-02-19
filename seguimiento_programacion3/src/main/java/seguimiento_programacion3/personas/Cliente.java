package seguimiento_programacion3.personas;

public class Cliente extends Persona{

    public Cliente() {
    }

    public Cliente(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String direccion, String correo) {
        super(numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, direccion, correo);
    }

    /**
     * Se realiza un ejemplo de sobre carga de constructores, en donde en el ultimo constructor se ignora
     * el campo dirección, es decir que, a nivel de sistema le permitiremos a los usuarios poder crear un
     * Cliente sin este campo como obligatorio
     * @param numeroDocumento
     * @param primerNombre
     * @param segundoNombre
     * @param primerApellido
     * @param segundoApellido
     * @param correo
     */
    public Cliente(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido,
                   String segundoApellido, String correo) {
        super(numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, null, correo);
    }

    /**
     * Ejemplo de sobrecarga de métodos.
     * @return Cliente
     * @param numeroDocumento
     * @param primerNombre
     * @param primerApellido
     * @param correo
     */
    public Cliente(String numeroDocumento, String primerNombre, String primerApellido, String correo) {
        super(numeroDocumento, primerNombre, null, primerApellido, null, null, correo);
    }
}
