package com.Met.edu.Doctor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Met.edu.Doctor.Entitities.State;


@Repository
public interface StateRepository  extends JpaRepository<State, Integer>{
	
	@Query("select s from State where stateId= :id")
	public State getStateById(int id);
	
	

}
