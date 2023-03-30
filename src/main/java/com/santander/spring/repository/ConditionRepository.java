package com.santander.spring.repository;

import com.santander.spring.entities.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionRepository extends JpaRepository<Condition,Long>{
    @Query("SELECT obj FROM Condition obj WHERE obj.clientId = :id")
    List<Condition> findConditionByClientId(Long id);

    @Query("Delete FROM Condition obj WHERE obj.clientId = :id")
    void deleteConditionByClientId(Long id);
}
