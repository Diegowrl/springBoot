package com.santander.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Condition implements Serializable{

	private static final long serialVersionUID = 1L;
	private UUID id;
	private int status;
	private Date createdAt;
	
	public Condition(UUID id, int status, Date createdAt) {
		this.id = id;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Condition() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condition other = (Condition) obj;
		return Objects.equals(createdAt, other.createdAt);
	}
	
	
	
	
}
