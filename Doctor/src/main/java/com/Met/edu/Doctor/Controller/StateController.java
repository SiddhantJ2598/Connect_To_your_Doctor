package com.Met.edu.Doctor.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Met.edu.Doctor.Entitities.State;
import com.Met.edu.Doctor.Services.StateService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StateController {
	
	@Autowired
	StateService sservice;
	
	public State getStateById( @PathVariable int  id) {
		
		return sservice.getById(id);
	}
	
	
	public List<State> getList(){
		
		return sservice.allStates();
	}	
	public State saveState(@RequestBody State s) {
		
		 return sservice.saveState(s);
	}

}
