package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "usuario", schema = "webcambridge")
public class Usuario {
    @Id
    @Column(name = "usuarioId", nullable = false)
    private int usuarioId;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;
    @Basic
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    @Basic
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
    @Basic
    @Column(name = "modoUsuario", nullable = false, length = 10)
    private String modoUsuario;
    @Basic
    @Column(name = "nivel", nullable = false)
    private int nivel;
    @Basic
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic
    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;
    @OneToMany(mappedBy = "usuarioByUsuarioId")
    private Collection<Inscripcioncurso> inscripcioncursosByUsuarioId;

    public Usuario(String nombre, String apellido, String cedula, String correo, String telefono, String modoUsuario, int nivel, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.modoUsuario = modoUsuario;
        this.nivel = nivel;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario(){

    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getModoUsuario() {
        return modoUsuario;
    }

    public void setModoUsuario(String modoUsuario) {
        this.modoUsuario = modoUsuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario1 = (Usuario) o;

        if (usuarioId != usuario1.usuarioId) return false;
        if (nivel != usuario1.nivel) return false;
        if (nombre != null ? !nombre.equals(usuario1.nombre) : usuario1.nombre != null) return false;
        if (apellido != null ? !apellido.equals(usuario1.apellido) : usuario1.apellido != null) return false;
        if (cedula != null ? !cedula.equals(usuario1.cedula) : usuario1.cedula != null) return false;
        if (correo != null ? !correo.equals(usuario1.correo) : usuario1.correo != null) return false;
        if (telefono != null ? !telefono.equals(usuario1.telefono) : usuario1.telefono != null) return false;
        if (modoUsuario != null ? !modoUsuario.equals(usuario1.modoUsuario) : usuario1.modoUsuario != null)
            return false;
        if (usuario != null ? !usuario.equals(usuario1.usuario) : usuario1.usuario != null) return false;
        if (contrasena != null ? !contrasena.equals(usuario1.contrasena) : usuario1.contrasena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usuarioId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (cedula != null ? cedula.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (modoUsuario != null ? modoUsuario.hashCode() : 0);
        result = 31 * result + nivel;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        return result;
    }

    public Collection<Inscripcioncurso> getInscripcioncursosByUsuarioId() {
        return inscripcioncursosByUsuarioId;
    }

    public void setInscripcioncursosByUsuarioId(Collection<Inscripcioncurso> inscripcioncursosByUsuarioId) {
        this.inscripcioncursosByUsuarioId = inscripcioncursosByUsuarioId;
    }
}
