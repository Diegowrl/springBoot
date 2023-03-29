package com.santander.spring.resources;

import java.net.URI;
import java.util.List;

import com.santander.spring.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.santander.spring.services.ClientServices;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/client")
public class ClientResources {

	@Autowired
	private ClientServices service;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){

		List<ClientDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){

		ClientDTO list = service.findById(id);

		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){

		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);
	}
}
