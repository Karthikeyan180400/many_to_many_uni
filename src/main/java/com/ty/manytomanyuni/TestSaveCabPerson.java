package com.ty.manytomanyuni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCabPerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Cab cab = new Cab();
		cab.setDriverName("Sathis");
		cab.setCost(150);

		Person person1 = new Person();
		person1.setName("Nishanth");
		person1.setAge(22);
		person1.setEmail("karthi@mail.com");

		Person person2 = new Person();
		person2.setName("Eeswar");
		person2.setAge(25);
		person2.setEmail("peter@mail.com");

		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);

		cab.setPerson(persons);
		entityTransaction.begin();
		entityManager.persist(cab);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityTransaction.commit();

	}

}
