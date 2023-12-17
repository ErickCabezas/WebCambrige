package com.example.webcambrige;

import java.util.ArrayList;
import java.util.List;

public class Gestor_ExamenUbicacion {
    private List<ExamenUbicacion> examenes;

    public Gestor_ExamenUbicacion() {
        this.examenes = new ArrayList<>();
        examenes.add(new ExamenUbicacion(1,"18/12/2023","7-9"));
        examenes.add(new ExamenUbicacion(2,"18/12/2023","11-13"));
        examenes.add(new ExamenUbicacion(3,"18/12/2023","14-16"));
        examenes.add(new ExamenUbicacion(4,"18/12/2023","9-11"));
    }

    public List<ExamenUbicacion> getExamenes() {
        return examenes;
    }

    public ExamenUbicacion buscarExamen(int idexamen) {
        for (ExamenUbicacion examen : examenes) {
            if (examen.getId()==idexamen) {
                return examen;
            }
        }
        return null;
    }

    public String agregarExamen(ExamenUbicacion examenUbicacion) {
        String notificacion = "";
        if (examenes.add(examenUbicacion)) {
            notificacion = "examen agregado";
        } else {
            notificacion = "examen no agregado";
        }
        return notificacion;
    }

    public ExamenUbicacion examenConHorario(String horario){
        for(ExamenUbicacion examen: examenes){
            if(examen.getHorario().equalsIgnoreCase(horario)){
                return examen;
            }
        }
        return null;
    }

    public String eliminarExamen(int id) {
        String notificacion = "";
        ExamenUbicacion examen = buscarExamen(id);
        if (examen != null) {
            examenes.remove(examen);
            notificacion = "examen eliminado";
        } else {
            notificacion = "examen no existe";
        }
        return notificacion;
    }
}
