package com.santander.spring.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.santander.spring.dto.ClientDTO;
import com.santander.spring.entities.Status;
import com.santander.spring.services.ClientServices;
import com.santander.spring.services.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.santander.spring.entities.Condition;

@RestController
@RequestMapping(value = "/condition")
public class ConditionResources {
	@Autowired
	private ConditionService service;
	@PostMapping(value = "/{id}/{status}")
	public ResponseEntity updateClient(@PathVariable Long id , @PathVariable Status status){

		service.createNewStatus(id, status);
		
		return ResponseEntity.noContent().build();
	} 
}
