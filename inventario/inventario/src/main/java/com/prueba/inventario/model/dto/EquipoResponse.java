package com.prueba.inventario.model.dto;

import com.prueba.inventario.model.entities.Equipo;

import java.time.LocalDateTime;

public class EquipoResponse {

    Equipo equipo;
    private Double perdida;
    private Double valorActual;

    public EquipoResponse(Equipo equipo, Double perdida, Double valorActual) {
        this.equipo = equipo;
        this.perdida = perdida;
        this.valorActual = valorActual;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Double getPerdida() {
        return perdida;
    }

    public void setPerdida(Double perdida) {
        this.perdida = perdida;
    }

    public Double getValorActual() {
        return valorActual;
    }

    public void setValorActual(Double valorActual) {
        this.valorActual = valorActual;
    }
    @Override
    public String toString() {
        return "EquipoResponse{" +
                "equipo=" + equipo +
                ", perdida=" + perdida +
                ", valorActual=" + valorActual +
                '}';
    }

}