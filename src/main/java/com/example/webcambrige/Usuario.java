package com.example.webcambrige;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String telefono;
    private String modoUsuario;
    private Login login;
    private InscripcionCurso inscripcion;

    private int nivel;

    public Usuario(String nombre, String apellido, String cedula, String correo, String modoUsuario, String telefono, String usuario, String contrasenia) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.modoUsuario = modoUsuario;
        this.login = new Login(usuario, contrasenia);
        //TODO: PONER COMPOSICION O MODIFCAR SEGUN SEA
        this.nivel=0;
    }


    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getModoUsuario() {
        return modoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Login getLogin() {
        return login;
    }

    public String getCedula() {
        return cedula;
    }

    public InscripcionCurso getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionCurso inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", modoUsuario='" + modoUsuario + '\'' +
                ", login=" + login +
                ", inscripcion=" + inscripcion +
                ", nivel=" + nivel +
                '}';
    }
}
