package com.santander.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.spring.entities.Client;
import com.santander.spring.repository.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		
		return repository.findAll();
	};
	
}
