package com.ty.manytomanyuni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteSaveStudentCourse {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Course course1 = new Course();
		course1.setName("Java");
		course1.setDuration("1 year");

		Course course2 = new Course();
		course2.setName("SQL");
		course2.setDuration("6 months");
		
		Course course3 = new Course();
		course3.setName("HTML");
		course3.setDuration("6 months");

		Student student = new Student();
		student.setName("Karthi");
		student.setAge(22);

		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		

		student.setCourse(courses);

		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();

	}

}
