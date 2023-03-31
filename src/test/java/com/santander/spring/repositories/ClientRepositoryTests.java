package com.santander.spring.repositories;

import com.santander.spring.entities.Client;
import com.santander.spring.exceptions.ResourceNotFoundException;
import com.santander.spring.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ClientRepositoryTests {

    @Autowired
    private ClientRepository repository;
//    @Test
//    public void deleteShouldDeleteObjectWhenIdExist(){
//        Long id = 1L;
//        repository.deleteById(id);
//
//        Optional<Client> result = repository.findById(id);
//
//        Assertions.assertFalse(result.isPresent());
//    }

//    @Test
//    public void deleteShouldThrowExceptionWhenIdNotExist(){
//
//        Assertions.assertThrows(EmptyResultDataAccessException.class, () ->{
//            repository.deleteById(1000L);
//        });
//
//    }
}
