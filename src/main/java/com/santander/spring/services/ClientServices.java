package com.santander.spring.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.santander.spring.dto.ClientDTO;
import com.santander.spring.entities.Condition;
import com.santander.spring.entities.Status;
import com.santander.spring.exceptions.DataBaseException;
import com.santander.spring.exceptions.ResourceNotFoundException;
import com.santander.spring.repository.ConditionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.santander.spring.entities.Client;
import com.santander.spring.repository.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository repository;
	@Autowired
	private ConditionRepository conditionRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){

		Page<Client> list = repository.findAll(pageRequest);

		return list.map( x -> new ClientDTO(x));
	};

	@Transactional(readOnly = true)
	public  ClientDTO findById(Long id){

		Optional<Client> obj = repository.findById(id);

		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		var list = conditionRepository.findConditionByClientId(entity.getId());

		entity.setConditionList(list);

		return new ClientDTO(entity);
	};

	@Transactional
	public ClientDTO insert(ClientDTO dto) {

		Client entity = new Client();
		entity.setDocument(dto.getDocument());
		entity.setEmail(dto.getEmail());
		entity.setBrokerId(dto.getBrokerId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());

		entity = repository.save(entity);

		Condition condition = new Condition(entity.getId(), Status.Criado, Instant.now());

		List<Condition> list = new ArrayList<>();

		condition = conditionRepository.save(condition);

		list.add(condition);

		entity.setConditionList(list);

		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {

		try {
			Client entity = repository.getOne(id);

			entity.setDocument(dto.getDocument());
			entity.setEmail(dto.getEmail());
			entity.setBrokerId(dto.getBrokerId());
			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());

			entity = repository.save(entity);

			return new ClientDTO(entity);
		}catch (EntityNotFoundException ex){
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	public void delete(Long id) {

		try {
			conditionRepository.deleteConditionByClientId(id);
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e){
			throw new ResourceNotFoundException("Id not found" + id);
		} catch (DataIntegrityViolationException data){
			throw new DataBaseException("Integrity violation" + data.getMessage());
		}

	}
}
