package com.ideasback.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ideasback.springboot.backend.apirest.models.entity.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long> {
	
}
