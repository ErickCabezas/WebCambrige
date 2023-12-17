package servlet;

import java.time.LocalDate;

public class FechaMatricula {
    String fechaInicio;
    String fechaFin;

    public FechaMatricula( ) {
        this.fechaInicio= String.valueOf(LocalDate.now().plusMonths(1));
        this.fechaFin= String.valueOf(LocalDate.now().plusMonths(4));
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

}
