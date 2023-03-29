package com.santander.spring.services;

import java.util.List;

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
	public List<Client> findAll(){
		
		return repository.findAll();
	};
	
}
