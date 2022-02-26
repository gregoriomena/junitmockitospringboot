package org.gmr.junit5.ejemplos.models;

import org.gmr.junit5.ejemplos.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal saldo;

    public Cuenta(String persona, BigDecimal saldo) {

        this.persona = persona;
        this.saldo = saldo;
    }

    public void debito(BigDecimal monto){

        if (this.saldo.compareTo(monto) < 0){
            throw new DineroInsuficienteException("No hay dinero suficiente en la cuenta");
        }

        this.saldo = saldo.subtract(monto);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof  Cuenta)){
            return false;
        }

        Cuenta cuenta = (Cuenta) obj;
        if (persona == null && saldo == null){
            return cuenta.getPersona() == null && cuenta.getSaldo() == null;
        }

        if (persona == null){
            return cuenta.getPersona() == null && saldo.equals(cuenta.getSaldo());
        }

        if (saldo == null){
            return cuenta.getSaldo() == null && persona.equals(cuenta.getPersona());
        }

        return persona.equals(cuenta.getPersona()) && saldo.equals(cuenta.getSaldo());
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
