package com.prueba.inventario.service.impl;

import com.prueba.inventario.model.dto.EquipoResponse;
import com.prueba.inventario.model.entities.Equipo;
import com.prueba.inventario.repository.EquipoRepository;
import com.prueba.inventario.service.EquipoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.prueba.inventario.utils.Constants.PORCENTAJE_DEPRECIACION;

@Service
public class EquipoServiceImpl implements EquipoService {


    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo actualizar(Long id, Equipo equipo) {

        Equipo equipoActual = equipoRepository.queryById(id);
        if (equipo.getDescripcion() != null) {
            equipoActual.setDescripcion(equipo.getDescripcion());
        }

        if (equipo.getFechaCompra() != null) {
            equipoActual.setFechaCompra(equipo.getFechaCompra());
        }
        if (equipo.getNombre() != null) {
            equipoActual.setNombre(equipo.getNombre());
        }
        if (equipo.getSerial() != null) {
            equipoActual.setSerial(equipo.getSerial());
        }
        if (equipo.getValorCompra() != null) {
            equipoActual.setValorCompra(equipo.getValorCompra());
        }
        return equipoRepository.save(equipoActual);
    }

    @Override
    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public EquipoResponse obtenerPorId(Long id) {
        Equipo equipo = equipoRepository.queryById(id);
        long anios = ChronoUnit.YEARS.between(equipo.getFechaCompra().toLocalDate(), LocalDate.now());
        double perdida = equipo.getValorCompra() * PORCENTAJE_DEPRECIACION * anios;

        double valorActual = equipo.getValorCompra() - perdida;
        if (valorActual < 0) valorActual = 0;

        return new EquipoResponse(equipo,perdida, valorActual);

    }
}