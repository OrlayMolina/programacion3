package seguimiento_programacion3.core;

import seguimiento_programacion3.personas.Cliente;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente() {
    }

    public CuentaCorriente(String numeroCta, Cliente cliente, String saldo) {
        super(numeroCta, cliente, saldo);
    }
}
