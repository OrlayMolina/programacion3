package seguimiento_programacion3.core;

import seguimiento_programacion3.exceptions.ValorRequeridoException;
import seguimiento_programacion3.personas.Cliente;

import java.util.Objects;

public class Cuenta {

    private String numeroCta;
    private Cliente cliente;
    private String saldo;

    public Cuenta (){

    }
    public Cuenta(String numeroCta, Cliente cliente, String saldo) {
        this.numeroCta = numeroCta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public static Cuenta of(String numeroCuenta,
                            Cliente cliente, String saldo) throws ValorRequeridoException {

        if (Objects.requireNonNull(numeroCuenta, "El número de cuenta es requerido").isEmpty()) {
            throw new ValorRequeridoException(" número de cuenta");
        }

        if (cliente == null) {
            throw new ValorRequeridoException(" el cliente es requerido");
        }

        if (Objects.requireNonNull(saldo, "El saldo del cliente es requerido").isEmpty()) {
            throw new ValorRequeridoException(" el saldo");
        }


        return new Cuenta(numeroCuenta, cliente, saldo);
    }

    public String getNumeroCta() {
        return numeroCta;
    }

    public void setNumeroCta(String numeroCta) {
        this.numeroCta = numeroCta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
