package com.training.boot.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.boot.associations.Patient;
import com.training.boot.associations.VisitHistory;

@SpringBootTest
class TestAssociationMapping {

	@Autowired
	PatientRepository repository;

	// @Autowired
//	VisitHistoryRepository visitRepository;

	@Test
	void testcreate() {
		Patient p1 = new Patient();
		p1.setFirstName("jill");
		p1.setLastName("mathew");
		p1.setEmail("jill@test.com");

		// visithistory
		VisitHistory v1 = new VisitHistory();
		v1.setPhysician("Mr. ABC");
		v1.setVisitDate(LocalDate.of(2021, Month.JULY, 20));
		v1.setPatient(p1); // done by orm

		// visithistory
		VisitHistory v2 = new VisitHistory();
		v2.setPhysician("Mr. ABC");
		v2.setVisitDate(LocalDate.of(2021, Month.JUNE, 21));
		v2.setPatient(p1); // done by orm

		// collection
		List<VisitHistory> visits = new ArrayList<VisitHistory>();
		visits.add(v1);
		visits.add(v2);
		;
		p1.setVisits(visits); // patient has 2 visits

		repository.save(p1); // behavior save() -> insert as well as update
		// visitRepository.save(v1);
		// visitRepository.save(v2);

	}

	// Default behavior of JPA - Lazy Loading
	// success - only when we changed fetch type to eager
	@Test
	public void testFinder() {

		Patient p = repository.findById(7).get();

		// select
		System.out.println("Patient details - " + p.getFirstName() + " " + p.getEmail());

		// 2 select
		System.out.println("Visit Details - " + p.getVisits());

	}

	// update query
	// update
	@Test
	public void testUpdatePatientVisits() {

		Patient patient = repository.findById(7).get();
		patient.setFirstName("peter");

		List<VisitHistory> visits = patient.getVisits();
		visits.forEach(v -> {
			if (v.getVisitId() == 8) {
				v.setPhysician("Mr. XYZ");
			}
		});
		repository.save(patient);
	}

	// delete

	@Test
	public void testDeletePatient() {

		repository.deleteById(10);
	}

	// count the visit of patients

	@Test
	public void countPatientVisits() {

		//Patient patient = repository.findById(7).get();
		//List<VisitHistory> visits = patient.getVisits();
		System.out.println("count - " + repository.count());
	}

}
