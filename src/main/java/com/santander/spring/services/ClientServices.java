package com.santander.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.santander.spring.dto.ClientDTO;
import com.santander.spring.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.santander.spring.entities.Client;
import com.santander.spring.repository.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){

		List<Client> list = repository.findAll();

		return list.stream().map( x -> new ClientDTO(x)).collect(Collectors.toList());
	};

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id){

		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	};
}
