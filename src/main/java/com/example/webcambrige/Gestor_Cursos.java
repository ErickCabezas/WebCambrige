package com.example.webcambrige;

import java.util.ArrayList;
import java.util.List;

public class Gestor_Cursos {
    private List<CursoIngles> cursos;

    public Gestor_Cursos() {
        this.cursos = new ArrayList<>();
        cursos.add(new CursoIngles(1, 103, "3/01/2024", "3/03/2024", "11-13", 4, 300));
        cursos.add(new CursoIngles(2, 104, "3/01/2024", "3/03/2024", "11-13", 4, 300));
        cursos.add(new CursoIngles(3, 105, "3/01/2024", "3/03/2024", "11-13", 5, 300));
        cursos.add(new CursoIngles(4, 106, "3/01/2024", "3/03/2024", "7-9", 4, 300));
        cursos.add(new CursoIngles(5, 107, "3/01/2024", "3/03/2024", "11-13", 5, 300));
        cursos.add(new CursoIngles(6, 108, "3/01/2024", "3/03/2024", "18-20", 1, 300));
    }

    public List<CursoIngles> getCursos() {
        return cursos;
    }

    public CursoIngles buscarCurso(int idCurso) {
        for (CursoIngles curso : cursos) {
            if (curso.getId()==idCurso) {
                return curso;
            }
        }
        return null;
    }

    public String agregarCurso(CursoIngles curso) {
        String notificacion = "";
        if (cursos.add(curso)) {
            notificacion = "curso agregado";
        } else {
            notificacion = "curso no agregado";
        }
        return notificacion;
    }

    public CursoIngles CursosConHorario(String horario, int nivel){
        for(CursoIngles curso: cursos){
            if(curso.getNivel()==nivel
                    &&curso.getHorarioCurso().equalsIgnoreCase(horario)){
                return curso;
            }
        }
        return null;
    }

    public String eliminarCurso(int id) {
        String notificacion = "";
        CursoIngles curso = buscarCurso(id);
        if (curso != null) {
            cursos.remove(curso);
            notificacion = "curso eliminado";
        } else {
            notificacion = "curso no existe";
        }
        return notificacion;
    }


}
