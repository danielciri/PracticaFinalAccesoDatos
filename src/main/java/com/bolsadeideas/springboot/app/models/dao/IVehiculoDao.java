package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Vehiculo;

public interface IVehiculoDao extends JpaRepository<Vehiculo, Long>{

}
