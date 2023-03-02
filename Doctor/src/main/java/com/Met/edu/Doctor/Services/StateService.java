package com.Met.edu.Doctor.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Met.edu.Doctor.Entitities.State;
import com.Met.edu.Doctor.Repository.StateRepository;

public class StateService {

	@Autowired
	StateRepository srepo;
	
	public List<State> allStates(){
		return srepo.findAll();
		
	}
	
	public State getById(int id) {
		return srepo.getStateById(id);
		
	}
	
	public State saveState(State s) {
		try {
			return srepo.save(s);
		}
		catch (Exception e) {
			return null;
		}
		
	}
	
	
	
}
