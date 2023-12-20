package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Cursoingles {
    @Id
    @Column(name = "cursoInglesId", nullable = false)
    private int cursoInglesId;
    @Basic
    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;
    @Basic
    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;
    @Basic
    @Column(name = "horarioCurso", nullable = false, length = 50)
    private String horarioCurso;
    @Basic
    @Column(name = "nivel", nullable = false)
    private int nivel;
    @Basic
    @Column(name = "aula", nullable = false)
    private int aula;
    @Basic
    @Column(name = "costo", nullable = false, precision = 0)
    private double costo;
    @OneToMany(mappedBy = "cursoinglesByCursoIngles")
    private Collection<Inscripcioncurso> inscripcioncursosByCursoInglesId;

    public Cursoingles(Date fechaInicio, Date fechaFin, String horarioCurso, int nivel, int aula, double costo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horarioCurso = horarioCurso;
        this.nivel = nivel;
        this.aula = aula;
        this.costo = costo;
    }

    public Cursoingles(){

    }

    public int getCursoInglesId() {
        return cursoInglesId;
    }

    public void setCursoInglesId(int cursoInglesId) {
        this.cursoInglesId = cursoInglesId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHorarioCurso() {
        return horarioCurso;
    }

    public void setHorarioCurso(String horarioCurso) {
        this.horarioCurso = horarioCurso;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cursoingles that = (Cursoingles) o;

        if (cursoInglesId != that.cursoInglesId) return false;
        if (nivel != that.nivel) return false;
        if (aula != that.aula) return false;
        if (Double.compare(costo, that.costo) != 0) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (horarioCurso != null ? !horarioCurso.equals(that.horarioCurso) : that.horarioCurso != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cursoInglesId;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (horarioCurso != null ? horarioCurso.hashCode() : 0);
        result = 31 * result + nivel;
        result = 31 * result + aula;
        temp = Double.doubleToLongBits(costo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Collection<Inscripcioncurso> getInscripcioncursosByCursoInglesId() {
        return inscripcioncursosByCursoInglesId;
    }

    public void setInscripcioncursosByCursoInglesId(Collection<Inscripcioncurso> inscripcioncursosByCursoInglesId) {
        this.inscripcioncursosByCursoInglesId = inscripcioncursosByCursoInglesId;
    }

    @Override
    public String toString() {
        return "cursoInglesId = " + cursoInglesId + "\n" +
                ", fechaInicio = " + fechaInicio + "\n" +
                ", fechaFin = " + fechaFin + "\n" +
                ", horarioCurso = " + horarioCurso + "\n" +
                ", nivel = " + nivel + "\n" +
                ", aula = " + aula + "\n" +
                ", costo = " + costo + "\n";
    }

    public void agregarCurso(Cursoingles cursoingles){
        EntityTransaction transaction = null;
        try{
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(cursoingles);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error durante la transaccion");
        }
    }
}