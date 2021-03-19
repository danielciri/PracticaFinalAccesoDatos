package com.bolsadeideas.springboot.app.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Pais;

public interface IPaisDao extends JpaRepository<Pais, String>{

}
