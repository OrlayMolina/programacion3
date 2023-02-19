package seguimiento_programacion3.core;


public class Deposito {

    public void depositar(Float monto, Cuenta cuenta) {

        cuenta.setSaldo(cuenta.getSaldo() + monto);
    }
}




