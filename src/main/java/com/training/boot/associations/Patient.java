package com.training.boot.associations;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// Serializable interface  - marker interface for object data converted into bytes to be sent over network
// Owning entity
@Entity
@Table(name = "patients")
public class Patient implements Serializable {

	@Id // mark field as primary key
	// @GeneratedValue(strategy = GenerationType.AUTO) // by default hibernate uses
	// SEQUENCE code algorithm strategies
	@GeneratedValue
	private Integer patientId;

	@Column(name = "patientfirstname", nullable = false, length = 30)
	private String firstName;

	@Column(name = "patientlastname", nullable = false, length = 30)
	private String lastName;

	@Column(nullable = false)
	private String email;

	@UpdateTimestamp
	private LocalDateTime updatedDateTime;

	@CreationTimestamp
	private LocalDateTime bookedDate;

	// @Transient
	// private int age;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<VisitHistory> visits;

	public Patient() {

		System.out.println("Patient No-args constructor");
	}

	public Patient(Integer patientId, String firstName, String lastName, String email) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Patient(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public LocalDateTime getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(LocalDateTime bookedDate) {
		this.bookedDate = bookedDate;
	}

	public List<VisitHistory> getVisits() {
		return visits;
	}

	public void setVisits(List<VisitHistory> visits) {
		this.visits = visits;
	}

}
