package seguimiento_programacion3.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaccion {

    private String valorTransaccion;
    private LocalDate fechaTransaccion;
    private LocalDateTime horaTransaccion;
    private Estado estado;

    public Transaccion(){

    }

    public Transaccion(String valorTransaccion, LocalDate fechaTransaccion, LocalDateTime horaTransaccion, Estado estado) {
        this.valorTransaccion = valorTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.horaTransaccion = horaTransaccion;
        this.estado = estado;
    }

    public String getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(String valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public LocalDateTime getHoraTransaccion() {
        return horaTransaccion;
    }

    public void setHoraTransaccion(LocalDateTime horaTransaccion) {
        this.horaTransaccion = horaTransaccion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
