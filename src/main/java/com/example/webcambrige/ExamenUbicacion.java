package com.example.webcambrige;

public class ExamenUbicacion {

    private int id;

    private String horario;

    private String fechaExamen;

    public ExamenUbicacion(int id,String fechaExamen, String horario) {
        this.id=id;
        this.fechaExamen = fechaExamen;
        this.horario=horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "ExamenUbicacion{" +
                "id=" + id +
                ", horario='" + horario + '\'' +
                ", fechaExamen='" + fechaExamen + '\'' +
                '}';
    }
}
