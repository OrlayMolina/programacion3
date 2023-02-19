package seguimiento_programacion3.core;

import seguimiento_programacion3.personas.Cliente;

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
