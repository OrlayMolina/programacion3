package seguimiento_programacion3.core;

import seguimiento_programacion3.personas.Cliente;

public class CuentaAhorro extends Cuenta{

    public CuentaAhorro() {
    }

    public CuentaAhorro(String numeroCta, Cliente cliente, String saldo) {
        super(numeroCta, cliente, saldo);
    }
}
