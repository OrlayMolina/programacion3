package seguimiento_programacion3.core;

public enum BancoController {

    INSTANCE;
    private final Banco banco;

    BancoController() {
        banco = new Banco();
    }

    public Banco getBanco() {
        return banco;
    }
}
