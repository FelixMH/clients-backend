package com.ideasback.springboot.backend.apirest.models.service;

import java.util.List;
import java.util.Optional;

import com.ideasback.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> buscarClientes();
	public Optional<Cliente> buscarCliente( Long id );
	public Cliente guardar( Cliente cliente );
	public void borrar( Long id );
}
