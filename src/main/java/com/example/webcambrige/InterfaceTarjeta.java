package com.example.webcambrige;

public interface InterfaceTarjeta {
    public RespuestaTarjeta solicitudDePago(SolicitudTarjeta solicitudPago);
    public RespuestaTarjeta cancelarPago(SolicitudTarjeta solicitudcancelar);
}

