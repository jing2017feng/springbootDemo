package com.ocloudwork.boot.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ocloudwork.boot.demo.mongo.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	Person findByName(String name);

	@Query("{'age': ?0}")
	List<Person> withQueryFindByAge(Integer age);
}
