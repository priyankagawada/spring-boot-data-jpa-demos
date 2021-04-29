package com.training.boot.associations;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

@Entity(name="visit_history")
public class VisitHistory {
	
	@Id
	@GeneratedValue
	private Integer VisitId;
	
	//@CreatedDate
	private LocalDate visitDate;
	
	private String physician;

	@ManyToOne
	@JoinColumn(name = "pat_id") // specifies the name of the foreign key column in the table
	private Patient patient;
	
	public VisitHistory() {
		
	}
	public VisitHistory(LocalDate visitDate, String physician) {
		this.visitDate = visitDate;
		this.physician = physician;
	}

	public Integer getVisitId() {
		return VisitId;
	}

	public void setVisitId(Integer visitId) {
		VisitId = visitId;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public String getPhysician() {
		return physician;
	}

	public void setPhysician(String physician) {
		this.physician = physician;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
