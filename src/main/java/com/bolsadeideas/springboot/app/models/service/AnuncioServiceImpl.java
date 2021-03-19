package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IAnuncioDao;
import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Anuncio;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Service
public class AnuncioServiceImpl implements IAnuncioService {

	@Autowired
	private IAnuncioDao clienteDao;

	@Override
	public List<Anuncio> findAll() {
		// TODO Auto-generated method stub
		return (List<Anuncio>) clienteDao.findAll();
	}

	@Override
	public void save(Anuncio Anuncio) {
		// TODO Auto-generated method stub
		clienteDao.save(Anuncio);
	}

	@Override
	public Anuncio findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long idAnuncio) {
		clienteDao.deleteById(idAnuncio);
		
	}

	@Override
	public Page<Anuncio> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}


	

}
