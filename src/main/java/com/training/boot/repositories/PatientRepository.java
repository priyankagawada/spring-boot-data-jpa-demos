package com.training.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.boot.associations.Patient;

public interface PatientRepository  extends CrudRepository<Patient, Integer>{

}
