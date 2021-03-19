package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IVehiculoDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vehiculo> findAll() {
		// TODO Auto-generated method stub
		return (List<Vehiculo>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Vehiculo vehiculo) {
		clienteDao.save(vehiculo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Vehiculo findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idVehiculo) {
		clienteDao.deleteById(idVehiculo);
		
	}

	@Override
	public Page<Vehiculo> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}
}
