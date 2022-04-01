package com.mayab.desarrollo.springMongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CustomerRepository extends MongoRepository<Customer, Long>{
	//Customer findById(long id);
	@Query("{address: '?0'}")
	List<Customer>findUserByAddress(String address);
	
	@Query("{address: { $regex :'?0' } }")
	List<Customer>findCustomByRegExAddress(String domain);
}
