package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IPaisDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Pais;

@Service
public class PaisServiceImpl implements IPaisService {

	@Autowired
	private IPaisDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pais> findAll() {
		// TODO Auto-generated method stub
		return (List<Pais>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Pais pais) {
		clienteDao.save(pais);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Pais findOne(String nombre) {
		// TODO Auto-generated method stub
		return clienteDao.findById(nombre).orElse(null);
	}
	
	@Override
	public Page<Pais> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}
}
