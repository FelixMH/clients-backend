package com.ideasback.springboot.backend.apirest.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.ideasback.springboot.backend.apirest.models.dao.IClientesDao;
import com.ideasback.springboot.backend.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClientesDao clienteDao;
	
	@Override
	@Transactional( readOnly = true )
	public List<Cliente> buscarClientes() {
		return ( List<Cliente> )clienteDao.findAll();
	}

	@Override
	@Transactional( readOnly = true )
	public Optional<Cliente> buscarCliente(Long id) {
		return clienteDao.findById(id);
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void borrar(Long id) {
		clienteDao.deleteById( id );
	}
	
	

	
	
}
