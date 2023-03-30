package com.santander.spring.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.spring.entities.Condition;

@RestController
@RequestMapping(value = "/condition")
public class ConditionResources {
 
	@GetMapping
	public ResponseEntity<List<Condition>> findAll(){
		
		List<Condition> list = new ArrayList<>();
		
		//list.add(new Condition(UUID.randomUUID(), 1 , new Instant));
		//list.add(new Condition(UUID.randomUUID(), 2 ,new Instant));
		
		return ResponseEntity.ok().body(list);
	} 
}
