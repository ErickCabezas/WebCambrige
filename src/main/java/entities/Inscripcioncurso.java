package entities;

import com.example.webcambrige.ProcesoPago;
import jakarta.persistence.*;

import java.sql.Date;

import static entities.ConexionBD.entityManager;

@Entity
public class Inscripcioncurso {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "usuarioId", nullable = false, insertable=false, updatable=false)
    private int usuarioId;
    @Basic
    @Column(name = "fechaInscripcion", nullable = false)
    private Date fechaInscripcion;
    @Basic
    @Column(name = "examenUbicacionId", nullable = false, insertable=false, updatable=false)
    private int examenUbicacionId;
    @Basic
    @Column(name = "pagado", nullable = false)
    private byte pagado;
    @Basic
    @Column(name = "cursoIngles", nullable = false, insertable=false, updatable=false)
    private int cursoIngles;
    @ManyToOne
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioId", nullable = false)
    private Usuario usuarioByUsuarioId;
    @ManyToOne
    @JoinColumn(name = "examenUbicacionId", referencedColumnName = "id", nullable = false)
    private Examenubicacion examenubicacionByExamenUbicacionId;
    @ManyToOne
    @JoinColumn(name = "cursoIngles", referencedColumnName = "cursoInglesId", nullable = false)
    private Cursoingles cursoinglesByCursoIngles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getExamenUbicacionId() {
        return examenUbicacionId;
    }

    public void setExamenUbicacionId(int examenUbicacionId) {
        this.examenUbicacionId = examenUbicacionId;
    }

    public byte getPagado() {
        return pagado;
    }

    public void setPagado(byte pagado) {
        this.pagado = pagado;
    }

    public int getCursoIngles() {
        return cursoIngles;
    }

    public void setCursoIngles(int cursoIngles) {
        this.cursoIngles = cursoIngles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscripcioncurso that = (Inscripcioncurso) o;

        if (id != that.id) return false;
        if (usuarioId != that.usuarioId) return false;
        if (examenUbicacionId != that.examenUbicacionId) return false;
        if (pagado != that.pagado) return false;
        if (cursoIngles != that.cursoIngles) return false;
        if (fechaInscripcion != null ? !fechaInscripcion.equals(that.fechaInscripcion) : that.fechaInscripcion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + usuarioId;
        result = 31 * result + (fechaInscripcion != null ? fechaInscripcion.hashCode() : 0);
        result = 31 * result + examenUbicacionId;
        result = 31 * result + (int) pagado;
        result = 31 * result + cursoIngles;
        return result;
    }

    public Usuario getUsuarioByUsuarioId() {
        return usuarioByUsuarioId;
    }

    public void setUsuarioByUsuarioId(Usuario usuarioByUsuarioId) {
        this.usuarioByUsuarioId = usuarioByUsuarioId;
    }

    public Examenubicacion getExamenubicacionByExamenUbicacionId() {
        return examenubicacionByExamenUbicacionId;
    }

    public void setExamenubicacionByExamenUbicacionId(Examenubicacion examenubicacionByExamenUbicacionId) {
        this.examenubicacionByExamenUbicacionId = examenubicacionByExamenUbicacionId;
    }

    public Cursoingles getCursoinglesByCursoIngles() {
        return cursoinglesByCursoIngles;
    }

    public void setCursoinglesByCursoIngles(Cursoingles cursoinglesByCursoIngles) {
        this.cursoinglesByCursoIngles = cursoinglesByCursoIngles;
    }

    public static Inscripcioncurso buscarInscripcionPorUsuario(int usuarioId){
        try {
            String query = "SELECT i FROM Inscripcioncurso i WHERE i.usuarioId = :usuarioId";

            // Utiliza directamente los parámetros en la consulta
            Inscripcioncurso inscripcionCurso = entityManager
                    .createQuery(query, entities.Inscripcioncurso.class)
                    .setParameter("usuarioId", usuarioId)
                    .getSingleResult();

            // No es necesario verificar si usuarioExistente != null, ya que getSingleResult() lanzará una excepción si no se encuentra ningún resultado
            return inscripcionCurso;

        } catch (NoResultException e) {
            // Maneja el caso en que no se encuentra ningún resultado (usuario no existe)
            return null;

        } catch (Exception e) {
            // Maneja otras excepciones de manera específica o regístralas
            e.printStackTrace();
            return null;

        }
    }

}