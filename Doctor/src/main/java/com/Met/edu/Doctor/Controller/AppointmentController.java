package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ConnectToYourDoctorApllication;
import com.example.demo.entities.Appointmententity;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.services.AppointmentService;
import com.example.demo.services.DoctorService;
import com.example.demo.services.PatientService; 
@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class AppointmentController {
	
	@Autowired
	AppointmentService aservice;
	
	@Autowired
	DoctorService dservice;
	
	@Autowired
	PatientService pservice;
	

	
	@PostMapping("/saveappointment")
	public Appointmententity saveAppointment(@RequestBody Appointmententity a) {
		return aservice.saveAppointment(a);
	}
	
	@PostMapping("/cancelappointment")
	public Appointmententity cancelAppointment(@RequestBody Appointmententity a) {
		return aservice.cancelAppointment(a);
	}
	
	@GetMapping("/allappointments")
	public List<Appointmententity> getAllAppointment(){
		return aservice.getAllAppointment();
	}
	
	@GetMapping("/appointmentsbydid/{id}")
	public List<Appointmententity> getAppointmentByDid(@PathVariable int id){
		Doctor d = dservice.getOneById(id);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		Date date1 = null;
		try {
			date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date1);
		return aservice.getAppointmentByDid(d, date1);
	}
	
	@GetMapping("/getappointmenthistorybydid/{id}")
	public List<Appointmententity> getAppointmentHistoryByDid(@PathVariable int id){
		Doctor d = dservice.getOneById(id);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		Date date1 = null;
		try {
			date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date1);
		return aservice.getAppointmentHistoryByDid(d, date1);
	}
	
	@GetMapping("/getappointmenthistorybypid/{id}")
	public List<Appointmententity> getAppointmentHistoryByPid(@PathVariable int id){
		Patient p = pservice.getOneById(id);

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		Date date1 = null;
		try {
			date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date1);

		
		return aservice.getAppointmentHistoryByPid(p,date1);
	}
	
	@GetMapping("/appointmentsbypatient/{id}")
	public List<Appointmententity> getAppointmentByPatient(@PathVariable int id){
		Patient p = pservice.getOneById(id);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		Date date1 = null;
		try {
			date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date1);


		return aservice.getAppointmentByPatient(p,date1);
	}
	
}

	
	


