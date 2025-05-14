package com.prueba.inventario.repository;

import com.prueba.inventario.model.dto.EquipoResponse;
import com.prueba.inventario.model.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo,Long> {

    Equipo queryById(@Param("id") Long id);



}
