package com.example.webcambrige;

public class ProcesoPago {
    private InterfaceTarjeta interfaceTarjeta;
    private Efectivo efectivo;

    public ProcesoPago(InterfaceTarjeta interfacePago) {
        this.interfaceTarjeta = interfacePago;
    }
    public ProcesoPago(double montoApagar) {
        this.efectivo=new Efectivo(montoApagar);
    }

    public boolean hacerPagoTarjeta(double montoAPagar){
        RespuestaTarjeta respuesta= interfaceTarjeta.solicitudDePago(new SolicitudTarjeta(montoAPagar));
        if(respuesta.getEstadoDeSolicitud()== RespuestaTarjeta.EstadoDeSolicitud.OK){
            return true;
        }else{
            return false;
        }
    }

    public boolean cancelarPagoTarjeta(boolean cancelar){
        RespuestaTarjeta respuesta= interfaceTarjeta.cancelarPago(new SolicitudTarjeta(cancelar));
        if(respuesta.getEstadoDeSolicitud()== RespuestaTarjeta.EstadoDeSolicitud.OK){
            return true;
        }else{
            return false;
        }
    }
    public boolean pagoEfectivo(){
        this.efectivo.setPagado(true);
        return this.efectivo.isPagado();
    }
}
