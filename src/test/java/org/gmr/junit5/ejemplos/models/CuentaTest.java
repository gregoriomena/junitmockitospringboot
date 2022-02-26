package org.gmr.junit5.ejemplos.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {

        Cuenta cuenta = new Cuenta("Gregorio", new BigDecimal("1000.55"));

        String esperado = "Gregorio";
        String real = cuenta.getPersona();

        assertEquals(esperado, real);
        assertTrue(esperado.equals(real));

    }

    @Test
    void testSaldoCuenta(){

        Cuenta cuenta = new Cuenta("Gregorio", new BigDecimal("1000.55"));

        assertEquals(1000.55, cuenta.getSaldo().doubleValue());
    }

    @Test
    void testReferenciaCuentaWhenParamsEquals() {

        Cuenta cuenta = new Cuenta("Juan Perez", new BigDecimal("2345.87"));
        Cuenta cuenta2 = new Cuenta("Juan Perez", new BigDecimal("2345.87"));

        assertEquals(cuenta, cuenta2);
    }

    @Test
    void testReferenciaCuentaWhenParamsNotEquals() {

        Cuenta cuenta = new Cuenta("Juan Mena", new BigDecimal("2345.87"));
        Cuenta cuenta2 = new Cuenta("Juan Perez", new BigDecimal("2345.87"));

        assertNotEquals(cuenta, cuenta2);
    }

    @Test
    void testReferenciaCuentaPersonaNull() {

        Cuenta cuenta = new Cuenta(null, new BigDecimal("2345.87"));
        Cuenta cuenta2 = new Cuenta("Juan Perez", new BigDecimal("2345.87"));
        assertNotEquals(cuenta, cuenta2);

        cuenta = new Cuenta("Juan Perez", new BigDecimal("2345.87"));
        cuenta2 = new Cuenta(null, new BigDecimal("2345.87"));
        assertNotEquals(cuenta, cuenta2);

        cuenta = new Cuenta(null, new BigDecimal("2345.87"));
        cuenta2 = new Cuenta(null, new BigDecimal("2345.87"));
        assertEquals(cuenta, cuenta2);
    }

    @Test
    void testReferenciaCuentaSaldoNull() {

        Cuenta cuenta = new Cuenta("Juan Perez", null);
        Cuenta cuenta2 = new Cuenta("Juan Perez", new BigDecimal("2345.87"));
        assertNotEquals(cuenta, cuenta2);

        cuenta = new Cuenta("Juan Perez", new BigDecimal("2345.87"));
        cuenta2 = new Cuenta("Juan Perez", null);
        assertNotEquals(cuenta, cuenta2);

        cuenta = new Cuenta("Juan Perez", null);
        cuenta2 = new Cuenta("Juan Perez", null);
        assertEquals(cuenta, cuenta2);
    }

    @Test
    void testReferenciaCuentaObjetoNoInstanceOfCuenta() {

        Cuenta cuenta = new Cuenta(null, new BigDecimal("2345.87"));
        assertNotEquals(cuenta, "Otra cosa");
    }

    @Test
    void testReferenciaCuentaNull() {

        Cuenta cuenta = new Cuenta(null, new BigDecimal("2345.87"));
        assertNotEquals(cuenta, null);
    }
}