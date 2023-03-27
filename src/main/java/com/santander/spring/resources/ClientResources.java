package com.santander.spring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.spring.entities.Client;


@RestController
@RequestMapping(value = "/client")
public class ClientResources {
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		
		List<Client> list = new ArrayList<>();
		
		list.add(new Client());
		
		return ResponseEntity.ok().body(list);
	} 
}
