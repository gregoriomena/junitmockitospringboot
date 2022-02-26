package org.gmr.junit5.ejemplos.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {

        Cuenta cuenta = new Cuenta();
        cuenta.setPersona("Gregorio");

        String esperado = "Gregorio";
        String real = cuenta.getPersona();

        assertEquals(esperado, real);
        assertTrue(esperado.equals(real));

    }
}