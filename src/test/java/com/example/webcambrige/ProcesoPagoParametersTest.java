package com.example.webcambrige;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(value = Parameterized.class)
public class ProcesoPagoParametersTest {

    private ProcesoPago pagoEfectivo;
    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{new ProcesoPago(300)});
        objects.add(new Object[]{new ProcesoPago(300)});
        objects.add(new Object[]{new ProcesoPago(300)});
        return objects;
    }


    public ProcesoPagoParametersTest(ProcesoPago pagoEfectivo) {
        this.pagoEfectivo=pagoEfectivo;
    }

    @Test
    public void given_parameters_when_pagoEfectivo_then_ok() {
        assertTrue(pagoEfectivo.pagoEfectivo());
    }



}
