package com.example.webcambrige;

public class CursoIngles {
    private int id;
    private String fechaInicio, fechaFin;
    private String horarioCurso;
    private int nivel;
    private int aula;
    private double costo;

    public CursoIngles(int id,int aula, String fechaInicio, String fechaFin, String horarioCurso, int nivel, double costo) {
        this.id=id;
        this.aula = aula;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.nivel=nivel;
        this.costo=costo;
        this.horarioCurso=horarioCurso;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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

    public String getHorarioCurso() {
        return horarioCurso;
    }

    public void setHorarioCurso(String horarioCurso) {

        this.horarioCurso = "Lunes-Viernes de: "+horarioCurso;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CursoIngles{" +
                "id=" + id +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", horarioCurso= Lunes-Viernes de " + horarioCurso + '\'' +
                ", nivel=" + nivel +
                ", aula=" + aula +
                ", costo=" + costo +
                '}';
    }
}
