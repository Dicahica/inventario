package com.prueba.inventario.service.impl;

import com.prueba.inventario.model.dto.EquipoResponse;
import com.prueba.inventario.model.entities.Equipo;
import com.prueba.inventario.repository.EquipoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipoServiceImplTest {

    @Mock
    private EquipoRepository equipoRepository;

    @InjectMocks
    private EquipoServiceImpl equipoService;

    @BeforeEach
    void SetUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerEquipos() {
        Equipo equipo1 = new Equipo();
        equipo1.setId(112L);
        equipo1.setNombre("Equipo1");
        equipo1.setSerial("12JU3JS3");
        equipo1.setDescripcion("Equipo de prueba 1");

        Equipo equipo2 = new Equipo();
        equipo2.setId(1134L);
        equipo2.setNombre("Equipo2");
        equipo2.setSerial("GDJEUA887");
        equipo2.setDescripcion("Equipo de prueba 2");

        when(equipoRepository.findAll()).thenReturn(Arrays.asList(equipo1, equipo2));

        List<Equipo> resultado = equipoService.obtenerEquipos();

        assertEquals(2, resultado.size());
        assertEquals("Equipo1",resultado.get(0).getNombre());
        assertEquals("Equipo2",resultado.get(1).getNombre());
        verify(equipoRepository, times(1)).findAll();

    }

    @Test
    void guardar() {
        Equipo equipo1 = new Equipo();
        equipo1.setId(112L);
        equipo1.setNombre("Equipo1");
        equipo1.setSerial("12JU3JS3");
        equipo1.setDescripcion("Equipo de prueba 1");

        when(equipoRepository.save(any(Equipo.class))).thenReturn(equipo1);

        Equipo guardado = equipoService.guardar(equipo1);

        assertNotNull(guardado);
        assertEquals("Equipo1", guardado.getNombre());
        verify(equipoRepository,times(1)).save(equipo1);

    }

    @Test
    void actualizar() {

        Equipo equipoExistente = new Equipo();
        equipoExistente.setId(1145L);
        equipoExistente.setNombre("Equipo Existente");
        equipoExistente.setSerial("345rtre");
        equipoExistente.setDescripcion("Equipo existente");

        Equipo equipoActualizado = new Equipo();
        equipoActualizado.setDescripcion("Se realiza actualizacion");

        when(equipoRepository.queryById(1145L)).thenReturn(equipoExistente);
        when(equipoRepository.save(any(Equipo.class))).thenReturn(equipoExistente);

        Equipo resultado = equipoService.actualizar(1145L,equipoActualizado);

        assertEquals("Se realiza actualizacion", resultado.getDescripcion());
        verify(equipoRepository, times(1)).queryById(1145L);
        verify(equipoRepository, times(1)).save(equipoExistente);
    }

    @Test
    void eliminar() {
        doNothing().when(equipoRepository).deleteById(1145L);

        equipoService.eliminar(1145L);

        verify(equipoRepository, times(1)).deleteById(1145L);
    }



    @Test
    void obtenerPorId() {
        Equipo equipo1 = new Equipo();
        equipo1.setId(112L);
        equipo1.setNombre("Equipo1");
        equipo1.setSerial("12JU3JS3");
        equipo1.setDescripcion("Equipo de prueba 1");
        equipo1.setFechaCompra(LocalDateTime.parse("2024-05-13T22:09:39.969"));
        equipo1.setValorCompra(1222000.0);

        when(equipoRepository.queryById(112L)).thenReturn(equipo1);

        EquipoResponse resultado = equipoService.obtenerPorId(112L);

        assertEquals("Equipo1", resultado.getEquipo().getNombre());
        assertEquals("12JU3JS3",resultado.getEquipo().getSerial());
        System.out.println(resultado);
        verify(equipoRepository, times(1)).queryById(112L);

    }
}