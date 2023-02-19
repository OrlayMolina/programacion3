package seguimiento_programacion3.utilidades;

import seguimiento_programacion3.core.Cuenta;

import java.util.function.Predicate;

public class CuentaUtil {

    public static Predicate<Cuenta> buscarPorNumeroCuenta(String numeroCuenta) {
        return cuenta -> cuenta.getNumeroCta().equals(numeroCuenta);
    }

    public static Predicate<Cuenta> buscarPorTitularCta(String titular) {
        return cuenta -> cuenta.getCliente().equals(titular);
    }

    public static Predicate<Cuenta> buscarPorSaldo(String saldo) {
        return cuenta -> cuenta.getSaldo().equals(saldo);
    }


    public static Predicate<Cuenta> buscarCuentaPorTodo(String numeroCuenta,
                                                        String titular, String saldo) {
        Predicate<Cuenta> predicado = cuenta -> true;

        if (numeroCuenta != null && !numeroCuenta.isEmpty()) {
            predicado = predicado.and(buscarPorNumeroCuenta(numeroCuenta));
        }
        if (titular != null && !titular.isEmpty()) {
            predicado = predicado.and(buscarPorTitularCta(titular));
        }
        if (saldo != null && !saldo.isEmpty()) {
            predicado = predicado.and(buscarPorSaldo(saldo));
        }

        return predicado;
    }
}
