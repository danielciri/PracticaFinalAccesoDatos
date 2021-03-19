package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.AgenciaVentaCoche;

public interface IAgenciaVentaCocheDao extends JpaRepository<AgenciaVentaCoche, Long> {

}
