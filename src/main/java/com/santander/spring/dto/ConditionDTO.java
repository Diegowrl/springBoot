package com.santander.spring.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class ConditionDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long clientId;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	private int status;
	private Instant createdAt;

	public ConditionDTO(Long id, Long clientId, int status, Instant createdAt) {
		this.clientId = clientId;
		this.id = id;
		this.status = status;
		this.createdAt = createdAt;
	}

	public ConditionDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public int hashCode() {
		return Objects.hash(createdAt);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConditionDTO other = (ConditionDTO) obj;
		return Objects.equals(createdAt, other.createdAt);
	}
}
