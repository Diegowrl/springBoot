package com.santander.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.santander.spring.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

}
