package com.santander.spring.services;

import com.santander.spring.entities.Condition;
import com.santander.spring.entities.Status;
import com.santander.spring.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class ConditionService {

    @Autowired
    private ConditionRepository conditionRepository;
    @Transactional
    public void createNewStatus(Long clientid, Status status) {
        conditionRepository.save(new Condition(clientid, status, Instant.now()));
    }
}
