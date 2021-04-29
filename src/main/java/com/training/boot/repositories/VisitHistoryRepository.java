package com.training.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.boot.associations.VisitHistory;

public interface VisitHistoryRepository extends CrudRepository<VisitHistory, Integer>{

}
