package com.santander.spring.dto;


import com.santander.spring.entities.Client;
import com.santander.spring.mapper.ConditionMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String document;
    private String firstName;
    private String lastName;
    private String email;
    private int brokerId;
    private List<ConditionDTO> conditionList = new ArrayList<>();

    public List<ConditionDTO> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<ConditionDTO> conditionList) {
        this.conditionList = conditionList;
    }
    public ClientDTO(Client client) {
        this.id = client.getId();
        this.document = client.getDocument();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.brokerId = client.getBrokerId();
        this.conditionList = client.getConditionList().stream().map(ConditionMapper.INSTANCE::mapToDto).toList();
    }

    public ClientDTO(Long id, String document, String firstName, String lastName, String email, int brokerId) {
        this.id = id;
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.brokerId = brokerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(int brokerId) {
        this.brokerId = brokerId;
    }
}
