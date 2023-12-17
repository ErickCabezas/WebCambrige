package com.example.webcambrige;

public class InscripcionCurso {
    private Usuario estudiante;
    private String fechaInscripcion;
    private ProcesoPago procesoPago;
    private ExamenUbicacion examenUbicacion;
    private CursoIngles curso;
    private boolean pagado;


    public InscripcionCurso(Usuario estudiante, String fechaInscripcion){
        this.estudiante=estudiante;
        this.fechaInscripcion=fechaInscripcion;
        this.pagado=false;
    }

    public boolean inscribirCurso(CursoIngles curso) {
        if (estudiante.getNivel()== 0) {
            return false;
        } else {
            this.curso=curso;
            return true;
        }
    }


    public CursoIngles getCurso() {
        return curso;
    }

    public void setExamenUbicacion(ExamenUbicacion examenUbicacion) {
        this.examenUbicacion = examenUbicacion;
    }

    public boolean pagar(String modoPago) {
        if(this.curso.getCosto()==300){
            if(modoPago.equalsIgnoreCase("efectivo")){
                procesoPago=new ProcesoPago(this.curso.getCosto());
                if(procesoPago.pagoEfectivo()){
                    this.pagado=true;
                }
            }
            if(modoPago.equalsIgnoreCase("tarjeta")){
                procesoPago=new ProcesoPago(this.curso.getCosto());
                this.pagado=true;
            }
            return pagado;
        }else{
            return false;
        }
    }

}
