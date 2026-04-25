package com.TangerineDigital.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.TangerineDigital.Repository.TaskRepository;
import com.TangerineDigital.model.TaskAccount;

@Service
public class TaskService {
	 private final TaskRepository TaskRepository;
	 private final java.util.concurrent.locks.ReentrantReadWriteLock ReentrantReadWriteLock;
	
	 public TaskService(TaskRepository TaskRepository) {
	        this.TaskRepository = TaskRepository;
			this.ReentrantReadWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
	    }
	 public Optional<TaskAccount> beforeInsert(int Value) {
	        return TaskRepository.findValue(Value);
	    }	
 
	 
	 /*
	 ReentrantReadWriteLock ==> increases concurrency, works efficient, 
	 has synchronization stratergy , avoids deadlock
	  * 
	  * 
	  */
	 public String getKeyWithValue(TaskAccount TaskAccount,int key) {
		 ReentrantReadWriteLock.readLock().lock();
    	if (TaskAccount.getId() != key) {
    		return "Value doesnot exists";
    	} 
    	int value = TaskAccount.getValue();
    	if (value == 0)
    		return "Value not found";
    	TaskAccount.setMostUsedID(key);
    	 ReentrantReadWriteLock.readLock().unlock();
        return String.valueOf(value);
    }
	 
	 public String insert(TaskAccount TaskAccount,int key, int value) {
		 ReentrantReadWriteLock.writeLock().lock();
    	if (TaskAccount.getId() == key) {
    		return "Duplicate Key";
    	}
    	
    	TaskAccount.setId(key);
    	TaskAccount.setValue(value);
    	TaskAccount.setMostUsedID(key);
    	TaskRepository.save(TaskAccount);
    	 ReentrantReadWriteLock.writeLock().unlock();
    	return "Successfylly added";
    }
	 
	 public String delete(TaskAccount TaskAccount,int key) {
		 ReentrantReadWriteLock.writeLock().lock();
    	if (TaskAccount.getId() != key) {
    		return "Value doesnot exists";
    	}
    	
    	if (TaskAccount.getMostUsedID() == key) {
    		//TaskAccount.setMostUsedID(); // TODO
    	}
    	
    	TaskRepository.delete(TaskAccount);
    	 ReentrantReadWriteLock.writeLock().unlock();
        return "Successfylly deleted";
    }
	 
	
    public String deleteAll(TaskAccount TaskAccount) {
    	ReentrantReadWriteLock.writeLock().lock();
    	TaskRepository.deleteAllInBatch();
        ReentrantReadWriteLock.writeLock().unlock();
        return "Successfylly deleted";
    }
    
public String statsDetailsValue(TaskAccount TaskAccount) {
	
	
    	int currentSize = TaskAccount.getMostUsedID();
    	int capacity = TaskAccount.getMostUsedID();
    	
        return "Successfylly deleted";
    }
  
}