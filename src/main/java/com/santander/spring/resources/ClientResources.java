package com.santander.spring.resources;

import java.net.URI;
import com.santander.spring.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){

		Page<ClientDTO> list = service.findAllPaged(pageable);

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

	@PutMapping(value = "{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto){

		dto = service.update(id, dto);

		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable Long id){

		service.delete(id);

		return ResponseEntity.noContent().build();
	}
}
