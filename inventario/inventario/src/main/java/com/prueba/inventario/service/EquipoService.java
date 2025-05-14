package com.prueba.inventario.service;

import com.prueba.inventario.model.dto.EquipoResponse;
import com.prueba.inventario.model.entities.Equipo;

import java.util.List;

public interface EquipoService {
    List<Equipo> obtenerEquipos();
    Equipo guardar(Equipo equipo);
    Equipo actualizar(Long id, Equipo equipo);
    void eliminar(Long id);
    EquipoResponse obtenerPorId(Long id);

}
