package com.example.demo.repositories;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Appointmententity;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointmententity, Integer>{

	@Query("select a.appointmentTime from Appointment a where doctor_id= :d and appointmentDate= :date")
	List<Object> getAppointmentByDidandDate(Doctor d, Date date);

	@Query("select a from Appointment a where doctor_id= :d and status = 'scheduled' and appointmentDate >= :date1")
	List<Appointmententity> getAppointmentByDid(Doctor d, java.util.Date date1);
	
	@Query("select a from Appointment a where doctor_id= :d and appointmentDate < :date1")
	List<Appointmententity> getAppointmentHistoryByDid(Doctor d, java.util.Date date1);

	@Query("select a from Appointment a where patient_id= :p and status = 'scheduled' and appointmentDate >= :date1")
	List<Appointmententity> getAppointmentByPatient(Patient p, java.util.Date date1);

	@Query("select a from Appointment a where patient_id= :p and appointmentDate < :date1")
	List<Appointmententity> getAppointmentHistoryByPid(Patient p, java.util.Date date1);
	
	
	

}

