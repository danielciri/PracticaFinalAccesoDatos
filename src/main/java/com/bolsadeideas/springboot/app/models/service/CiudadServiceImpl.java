package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.ICiudadDao;
import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Ciudad;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Service
public class CiudadServiceImpl implements ICiudadService {

	@Autowired
	private ICiudadDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAll() {
		// TODO Auto-generated method stub
		return (List<Ciudad>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Ciudad ciudad) {
		clienteDao.save(ciudad);
		
	}

	@Override
	public Page<Ciudad> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	@Override
	public Ciudad findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long idCiudad) {
		clienteDao.deleteById(idCiudad);
		
	}
}
