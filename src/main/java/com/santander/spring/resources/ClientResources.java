package com.santander.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.spring.entities.Client;
import com.santander.spring.services.ClientServices;


@RestController
@RequestMapping(value = "/client")
public class ClientResources {
	
	@Autowired
	private ClientServices service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		
		List<Client> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	} 
}
