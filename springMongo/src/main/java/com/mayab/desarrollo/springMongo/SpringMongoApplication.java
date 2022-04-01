package com.mayab.desarrollo.springMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository repo; 

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ya empeze");
		deleteAll(); 
		addSampleData();
		listAll(); 
		findUserByAddress();
		findCustomByRegExAddress();
		// findFirst();
		// findByRegex(); 
	}
	
	public void deleteAll() {
		System.out.println("Deleting all records..");
		repo.deleteAll();
	}
	
	public void addSampleData() {
		System.out.println("Adding Simple Data");
		repo.save(new Customer("Juan Perez", "Merida", 11111d)); 
		repo.save(new Customer("Lebron James", "Mexico", 22222d)); 
		repo.save(new Customer("Leo Garcia", "Noruega", 3333d)); 
		repo.save(new Customer("Juan Camaney", "Milxian", 44444d)); 
	}
	
	public void listAll() {
		System.out.println("Listing Simple Data");
		repo.findAll().forEach(u -> System.out.println(u));
	}
	
	public void findUserByAddress() {
		System.out.println("Finding by Address");
		repo.findUserByAddress("Noruega").forEach(u -> System.out.println(u));
	}
	
	public void findCustomByRegExAddress() {
		System.out.println("Finding by Regex address");
		repo.findCustomByRegExAddress("xi").forEach(u -> System.out.println(u));
	}

}
