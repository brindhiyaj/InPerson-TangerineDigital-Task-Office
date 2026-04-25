package com.TangerineDigital.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TangerineDigital.model.TaskAccount;
import com.TangerineDigital.service.TaskService;

@RestController
@RequestMapping("/cache")
public class TaskController {
   
	private final TaskService taskService;
   private TaskAccount taskAccount;
	   
   public TaskController(TaskService taskService) {
       this.taskService = taskService;
   }
   
   @GetMapping("/")
   public String getKeyValue(@RequestParam int value) {
   	return taskService.getKeyWithValue(taskAccount,value);
   }
   
    @PostMapping()
    public String insertValue(@RequestBody HashMap<String,String> requestBodyValues) {
    	String requestKey = requestBodyValues.get("key");
    	String requestValue = requestBodyValues.get("value");
    	return taskService.insert(taskAccount,Integer.parseInt(requestKey),Integer.parseInt(requestValue));
    }

    @DeleteMapping("/")
    public String deleteValue(@RequestParam int keyValue) {
    	return taskService.delete(taskAccount,keyValue);
    }
    
    @DeleteMapping("/all")
    public String deleteAllValue() {
    	return taskService.deleteAll(taskAccount);
    }
    
    @PostMapping("/stats")
    public String statsDetailsValue() {
    	return taskService.statsDetailsValue(taskAccount);
    }

}