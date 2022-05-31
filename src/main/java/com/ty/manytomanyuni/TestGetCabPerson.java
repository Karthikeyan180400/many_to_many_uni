package com.ty.manytomanyuni;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetCabPerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cab cab = entityManager.find(Cab.class, 2);
		if (cab != null) {
			System.out.println(" ");
			System.out.println("Driver Name " + cab.getDriverName());
			System.out.println("Cost " + cab.getCost());
			System.out.println("------------------------------------");
			List<Person> persons = cab.getPerson();
			for (Person person : persons) {
				System.out.println("Person Name " + person.getName());
				System.out.println("Age " + person.getAge());
				System.out.println("Email is " + person.getEmail());
				System.out.println("-----------------------------------");
			}
		} else {
			System.out.println("No Cab exists for Given Id");
		}

	}

}
