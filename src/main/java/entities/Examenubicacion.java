package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Examenubicacion {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "horario", nullable = false, length = 50)
    private String horario;
    @Basic
    @Column(name = "fechaExamen", nullable = false)
    private Date fechaExamen;
    @OneToMany(mappedBy = "examenubicacionByExamenUbicacionId")
    private Collection<Inscripcioncurso> inscripcioncursosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Examenubicacion that = (Examenubicacion) o;

        if (id != that.id) return false;
        if (horario != null ? !horario.equals(that.horario) : that.horario != null) return false;
        if (fechaExamen != null ? !fechaExamen.equals(that.fechaExamen) : that.fechaExamen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        result = 31 * result + (fechaExamen != null ? fechaExamen.hashCode() : 0);
        return result;
    }

    public Collection<Inscripcioncurso> getInscripcioncursosById() {
        return inscripcioncursosById;
    }

    public void setInscripcioncursosById(Collection<Inscripcioncurso> inscripcioncursosById) {
        this.inscripcioncursosById = inscripcioncursosById;
    }
}
