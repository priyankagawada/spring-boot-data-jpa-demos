package com.training.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.boot.repositories.entities.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity, Long>{

}
