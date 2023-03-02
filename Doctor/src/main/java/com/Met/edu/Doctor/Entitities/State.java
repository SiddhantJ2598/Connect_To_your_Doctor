package com.Met.edu.Doctor.Entitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="state_id")
	private int stateId;
	
	@Column(nullable = false, name= "state_name")
	private int stateName;

	

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(int stateName) {
		super();
		this.stateName = stateName;
	}


	public State(int stateId, int stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}


	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getStateName() {
		return stateName;
	}

	public void setStateName(int stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "StateEntity [stateId=" + stateId + ", stateName=" + stateName + "]";
	}
	
	

}
