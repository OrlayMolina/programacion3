package seguimiento_programacion3.core;

import seguimiento_programacion3.exceptions.PersonaExisteException;
import seguimiento_programacion3.exceptions.PersonaNoExisteException;
import seguimiento_programacion3.exceptions.ValorRequeridoException;
import seguimiento_programacion3.personas.Cliente;
import seguimiento_programacion3.personas.Empleado;
import seguimiento_programacion3.personas.Persona;
import seguimiento_programacion3.utilidades.CuentaUtil;
import seguimiento_programacion3.utilidades.PersonaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Banco {


    private String nombreEntidad;
    private String nit;
    private final List<Persona> clientes;
    private final List<Cuenta> cuentas;
    private final List<Transaccion> registrosBancarios;
    private final List<Persona> empleados;


    public Banco(String nombreEntidad, String nit, List<Persona> clientes, List<Cuenta> cuentas,
                 List<Transaccion> registrosBancarios, List<Persona> empleados) {
        this.nombreEntidad = nombreEntidad;
        this.nit = nit;
        this.clientes = clientes;
        this.cuentas = cuentas;
        this.registrosBancarios = registrosBancarios;
        this.empleados = empleados;
    }

    public Banco(){
        nombreEntidad = "Unibanco";
        nit = "900.458.125-3";
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
        registrosBancarios = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    public void adicionarPersona(Persona persona) throws PersonaExisteException {
        if (persona instanceof Cliente) {
            if (buscarPorNumeroIdentificacion(persona.getNumeroDocumento()).isPresent()) {
                throw new PersonaExisteException();
            }
            clientes.add((Cliente) persona);
        }
        if (persona instanceof Empleado) {
            if (buscarPorNumeroIdentificacion(persona.getNumeroDocumento()).isPresent()) {
                throw new PersonaExisteException();
            }
            empleados.add((Empleado) persona);
        }
    }

    public void removerPersona(String numeroIdentificacion) throws PersonaNoExisteException, ValorRequeridoException {
        if (Objects.requireNonNull(numeroIdentificacion, "El número de identificación es requerido").isEmpty()) {
            throw new ValorRequeridoException("número de identificación");
        }
        Optional<Persona> persona = buscarPorNumeroIdentificacion(numeroIdentificacion);
        if (persona.isEmpty()) {
            throw new PersonaNoExisteException();
        }
        if (persona.get() instanceof Cliente) {
            clientes.remove((Cliente) persona.get());
        }
        if (persona.get() instanceof Empleado) {
            empleados.remove((Empleado) persona.get());
        }
    }

    public Optional<Persona> buscarPorNumeroIdentificacion(String numeroIdentificacion) {
        Optional<Persona> personaEncontrada = clientes.stream()
                .filter(PersonaUtil.buscarPorNumeroIdentificacion(numeroIdentificacion))
                .findFirst();
        if (personaEncontrada.isEmpty()) {
            personaEncontrada = empleados.stream()
                    .filter(PersonaUtil.buscarPorNumeroIdentificacion(numeroIdentificacion))
                    .findFirst();
        }
        return personaEncontrada;
    }

    public List<Persona> buscar(String numeroIdentificacion, String primerNombre, String segundoNombre,
                                String primerApellido, String segundoApellido, String direccion, String correo) {

        List<Persona> personaEncontrada = clientes.stream()
                .filter(PersonaUtil.buscarPorTodo(numeroIdentificacion, primerNombre, segundoNombre, primerApellido,
                        segundoApellido, direccion, correo))
                .collect(Collectors.toUnmodifiableList());
        if (personaEncontrada.isEmpty()) {
            personaEncontrada = empleados.stream()
                    .filter(PersonaUtil.buscarPorTodo(numeroIdentificacion, primerNombre, segundoNombre, primerApellido,
                            segundoApellido, direccion, correo))
                    .collect(Collectors.toUnmodifiableList());
        }
        return personaEncontrada;
    }

    /*******************/

    public void adicionarCuenta(Cuenta cuenta) {


        cuentas.add(cuenta);
    }

    public void removerCuenta(Cuenta cuenta) throws PersonaNoExisteException, ValorRequeridoException  {

        cuentas.remove(cuenta);
    }
    public Optional<Cuenta> buscarPorTitularCta(String cliente) {
        return cuentas.stream()
                .filter(CuentaUtil.buscarPorTitularCta(cliente))
                .findFirst();
    }

    public List<Cuenta> buscarCuenta(String numeroCta, String cliente, String saldo) {
        return cuentas.stream()
                .filter(CuentaUtil.buscarCuentaPorTodo(numeroCta, cliente, saldo))
                .collect(Collectors.toUnmodifiableList());
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Persona> getClientes() {
        return clientes;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public List<Transaccion> getRegistrosBancarios() {
        return registrosBancarios;
    }

    public List<Persona> getEmpleados() {
        return empleados;
    }
}
