package com.example.webcambrige;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProcesoPagoTest {
    private InterfaceTarjeta interfacePago;
    private ProcesoPago procesar, pagoEfectivo;


    @Before
    public void setUp(){
        interfacePago = Mockito.mock(InterfaceTarjeta.class);
        procesar= new ProcesoPago(interfacePago);
        pagoEfectivo = new ProcesoPago(300);


    }
    @Test
    public void give_hacerPago_when_is_correct_then_OK(){
        Mockito.when(interfacePago.solicitudDePago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.OK));
        assertTrue(procesar.hacerPagoTarjeta(300));

    }
    @Test
    public void give_hacerPago_when_is_correct_then_Error(){
        Mockito.when(interfacePago.solicitudDePago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.ERROR));
        assertFalse(procesar.hacerPagoTarjeta(300));

    }

    @Test
    public void give_CancelarPago_when_is_correct_then_OK(){
        Mockito.when(interfacePago.cancelarPago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.OK));
        assertTrue(procesar.cancelarPagoTarjeta(true));
    }
    @Test
    public void give_CancelarPago_when_is_correct_then_Error(){
        Mockito.when(interfacePago.cancelarPago(Mockito.any())).thenReturn(
                new RespuestaTarjeta(RespuestaTarjeta.EstadoDeSolicitud.ERROR));
        assertFalse(procesar.cancelarPagoTarjeta(true));
    }

    @Test(timeout = 50)
    public void given_respuesta_when_pagoEfectivo_then_timeout() {
        assertTrue(pagoEfectivo.pagoEfectivo());
    }

}