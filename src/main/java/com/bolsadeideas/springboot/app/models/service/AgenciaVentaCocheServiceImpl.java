package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IAgenciaVentaCocheDao;
import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.AgenciaVentaCoche;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Service
public class AgenciaVentaCocheServiceImpl implements IAgenciaVentaCocheService {

	@Autowired
	private IAgenciaVentaCocheDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<AgenciaVentaCoche> findAll() {
		// TODO Auto-generated method stub
		return (List<AgenciaVentaCoche>)clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(AgenciaVentaCoche agenciaVentaCoche) {
		// TODO Auto-generated method stub
		clienteDao.save(agenciaVentaCoche);
		
	}


	@Override
	public Page<AgenciaVentaCoche> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}
	

}
