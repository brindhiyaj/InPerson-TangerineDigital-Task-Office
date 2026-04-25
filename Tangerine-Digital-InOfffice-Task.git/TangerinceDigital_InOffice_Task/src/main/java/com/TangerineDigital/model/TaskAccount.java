package com.TangerineDigital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaskAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int value;
    
    private int mostUsedID;

    private int mostUsedValue;
  
    public TaskAccount() {}

    public TaskAccount(int value) {
        this.value = value;
        
    }
    
    // getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getMostUsedID() {
		return mostUsedID;
	}

	public void setMostUsedID(int mostUsedID) {
		this.mostUsedID = mostUsedID;
	}

	public int getMostUsedValue() {
		return mostUsedValue;
	}

	public void setMostUsedValue(int mostUsedValue) {
		this.mostUsedValue = mostUsedValue;
	}

    
   
}