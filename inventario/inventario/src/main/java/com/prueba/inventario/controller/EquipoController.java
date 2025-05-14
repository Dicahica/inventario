package com.prueba.inventario.controller;

import com.prueba.inventario.model.dto.EquipoResponse;
import com.prueba.inventario.model.entities.Equipo;
import com.prueba.inventario.service.EquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipo")
@Tag(name = "Equipos", description = "Operaciones de gestion de equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @Operation(summary = "Obtener todos los productos")
    @GetMapping("/")
    public List<Equipo> obtenerTodos(){
        return equipoService.obtenerEquipos();
    }

    @Operation(summary = "Obtener equipo por id")
    @GetMapping("/{id}")
    public EquipoResponse obtenerPorId(@PathVariable Long id){
        return equipoService.obtenerPorId(id);
    }

    @Operation(summary = "Guardar un equipo")
    @PostMapping("/guardar")
    public  Equipo guardar(@RequestBody Equipo equipo){
        return equipoService.guardar(equipo);
    }

    @Operation(summary = "Eliminar un equipo por id")
    @DeleteMapping("/eliminar/{id}")
    public void eliminarEquipo(@PathVariable Long id){
        equipoService.eliminar(id);
    }

    @Operation(summary = "Actualizar un equipo")
    @PutMapping("/actualizar/{id}")
    public Equipo actualizarEquipo(@PathVariable Long id, @RequestBody Equipo equipo){
        return equipoService.actualizar(id, equipo);
    }
}
