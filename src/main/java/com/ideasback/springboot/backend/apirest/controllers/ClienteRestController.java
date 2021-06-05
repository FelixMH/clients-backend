package com.ideasback.springboot.backend.apirest.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ideasback.springboot.backend.apirest.models.entity.Cliente;
import com.ideasback.springboot.backend.apirest.models.service.IClienteService;

@CrossOrigin( origins = { "http://localhost:4200" } )
@RestController
@RequestMapping( "/api/v1" )
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping( value = "/clientes/buscar", method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
	public List<Cliente> buscarTodos()
	{
		return clienteService.buscarClientes();
	}
	
	@RequestMapping( value = "/clientes/buscar/{id}", method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
	public Optional<Cliente> buscarCliente( @PathVariable("id") Long id )
	{
		return clienteService.buscarCliente(id);
	}
	
	@RequestMapping( value = "/clientes/crear", method = RequestMethod.POST )
	@ResponseStatus( HttpStatus.CREATED )
	public Cliente crear( @RequestBody Cliente cliente )
	{
		return clienteService.guardar( cliente );
	}
	
	@RequestMapping( value = "/clientes/actualizar/{id}", method = RequestMethod.PUT )
	@ResponseStatus( HttpStatus.OK )
	public Cliente actualizar( @RequestBody Cliente cliente, @PathVariable Long id )
	{
		Cliente clienteActual = clienteService.buscarCliente(id).orElse(null);
		
		clienteActual.setNombre( cliente.getNombre() );
		clienteActual.setApellido( cliente.getApellido() );
		clienteActual.setEmail( cliente.getEmail() );
		
		return clienteService.guardar(clienteActual);
	}
	
	@RequestMapping( value = "/clientes/eliminar/{id}", method = RequestMethod.DELETE )
	@ResponseStatus( HttpStatus.NO_CONTENT )
	public void eliminar( @PathVariable Long id )
	{
		clienteService.borrar(id);
	}
}
