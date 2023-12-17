package com.example.webcambrige;

import java.util.ArrayList;
import java.util.List;

public class Gestor_Usuario {
    private List<Usuario> usuarios;

    public Gestor_Usuario() {
        this.usuarios = new ArrayList<>();
        Usuario usuario1=new Usuario("a","b","1751398924","erick.cabezas@epn.edu.ec","estudiante","0998369390","estudiante","123");
        Usuario usuario2=new Usuario("a","c","1751398924","erick.cabezas@epn.edu.ec","administrativo","0998369390","administrativo","123");
        Usuario usuario3=new Usuario("a","d","1751398924","erick.cabezas@epn.edu.ec","profesor","0998369390","profesor","123");
        agregarUsuario(new Usuario("Gerenacial","Gerencial","1751398924","---","gerencial","0999999999","gerente","123"));
        agregarUsuario(usuario1);
        agregarUsuario(usuario2);
        agregarUsuario(usuario3);
        usuario1.setNivel(4);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(String usuarioABuscar) {
        for (Usuario usuario : usuarios) {
            if (compararUsuario(usuarioABuscar, usuario)) {
                return usuario; // Persona encontrada
            }
        }
        return null; // Persona no encontrada
    }

    public boolean compararUsuario(String usuarioABuscar, Usuario usuario) {
        return usuario.getLogin().getUsuario().equals(usuarioABuscar);
    }


    public String agregarUsuario(Usuario usuario) {
        String notificacion = "";

        try {
            Thread.sleep(20);
            if (validarUsuario(usuario)) {
                usuarios.add(usuario);
                notificacion = "Usuario agregado";
            } else {
                notificacion = "Usuario no agregado";
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return notificacion;
    }

    private boolean validarUsuario(Usuario usuario) {
        return comprobarDatosValidos(usuario);
    }

    private boolean comprobarDatosValidos(Usuario usuario) {
        return validarCedulaEcuatoriana(usuario.getCedula()) && (buscarUsuario(usuario.getLogin().getUsuario()) == null)
                && comprobarNumeroSinLetras(usuario.getTelefono());
    }

    public boolean comprobarNumeroSinLetras(String telefono) {
        int telefonoEntero;
        try {
            telefonoEntero = Integer.parseInt(telefono);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }


    public String eliminarUsuario(Usuario usuarioAEliminar) {
        String notificacion = "";
        Usuario usuario = buscarUsuario(usuarioAEliminar.getLogin().getUsuario());
        if (usuario != null) {
            usuarios.remove(usuario);
            notificacion = "usuario eliminado";
        } else {
            notificacion = "usuario no existe";
        }
        return notificacion;
    }

    public boolean asignarNivel(Usuario usuario,double nota){
        boolean confirmacion=false;

            if(nota>=0 && nota<=20){
                usuario.setNivel(1);
                confirmacion=true;
            }
            if(nota>20 && nota<=40){
                usuario.setNivel(2);
                confirmacion=true;
            }
            if(nota>40 && nota<=60){
                usuario.setNivel(3);
                confirmacion=true;
            }
            if(nota>60 && nota<=80){
                usuario.setNivel(4);
                confirmacion=true;
            }
            if(nota>80 && nota<=100){
                usuario.setNivel(5);
                confirmacion=true;
            }

        return confirmacion;
    }

    public boolean validarCedulaEcuatoriana(String cedula) {
        // Verificar si la longitud del número de cédula es 10
        if (cedula.length() != 10) {
            return false;
        }

        // Verificar si todos los caracteres son dígitos
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(cedula.charAt(i))) {
                return false;
            }
        }

        // Obtener los dos primeros dígitos (provincia)
        int provincia = Integer.parseInt(cedula.substring(0, 2));

        // Verificar si la provincia está en el rango válido (01-24)
        if (provincia > 24 || provincia < 1) {
            return false;
        }

        // Verificar el tercer dígito (tipo de documento)
        int tipoDocumento = Integer.parseInt(cedula.substring(2, 3));

        // Verificar si el tipo de documento es válido (0, 1, 2, 3)
        if (tipoDocumento < 0 || tipoDocumento > 5) {
            return false;
        }

        // Validar el dígito verificador
        int verificador = Integer.parseInt(cedula.substring(9));
        return validarDigitoVerificador(cedula.substring(0, 9), verificador);
    }

    // Método para validar el dígito verificador
    private boolean validarDigitoVerificador(String cedulaBase, int verificador) {
        int suma = 0;

        //*
        for (int i = 0; i < cedulaBase.length(); i++) {
            int digito = Character.getNumericValue(cedulaBase.charAt(i));
            digito = getDigito(i, digito);
            suma += getSuma(digito);
        }

        int resultado = calcularResultado(suma);
        if (resultado == 10) {
            resultado = 0;
        }
        return resultado == verificador;
    }

    public int getDigito(int i, int digito) {
        return (i % 2 == 0) ? digito * 2 : digito;
    }

    public int getSuma(int digito) {
        return (digito > 9) ? digito - 9 : digito;
    }

    public int calcularResultado(int suma) {

        return 10 - (suma % 10);
    }

}
