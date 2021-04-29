package com.training.boot.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import javax.transaction.Transactional;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.boot.repositories.entities.UserEntity;

//Integration testing - testing whole application (end to end) with resources like database, transactions, rest api, security, MVC
// Tomcat web server
@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	UserEntity userEntity;

	@BeforeEach
	public void setup() {
		userEntity = new UserEntity();
		userEntity.setFirstName("John");
		userEntity.setLastName("Mexican");
		userEntity.setEmail("john@test.com");
		userEntity.setDOB(LocalDate.of(2001, Month.JUNE, 12));
		userEntity.setUserId("Pat1234");
		userEntity.setPassword("pass");
		userEntity.setConfirmPassword("pass");
	}

	@Test
	public void contextLoads() {
		System.out.println("Context loaded");
	}

	@Test
    public void testCreateUser() {
		UserEntity entity = repository.save(userEntity);
		

	}

	// To run specific test, select the testcase name, right-click and select Run as -> Junit test 
	@Test
	void testFind() {
		UserEntity entity = repository.findById(9L).get();
		assertNotNull(entity);
		assertEquals("John", entity.getFirstName());
	}

	@Test
	public void testUpdate() {

		UserEntity entity = repository.findById(1L).get();
		
	    assertNotNull(entity);
		assertEquals("johnmexican@test.com\"", entity.getEmail());
	}

	
	@Test
	public void testDelete() {
		if(repository.existsById(9L)) {
			System.out.println("Deleting the user data");
			repository.deleteById(9L);
		}
	}
	
}
