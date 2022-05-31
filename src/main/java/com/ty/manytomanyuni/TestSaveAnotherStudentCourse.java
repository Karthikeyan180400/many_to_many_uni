package com.ty.manytomanyuni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAnotherStudentCourse {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = new Student();
		student.setName("Nishanth");
		student.setAge(22);

		Course course1 = entityManager.find(Course.class, 3);
		Course course2 = entityManager.find(Course.class, 2);
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);

		student.setCourse(courses);

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

	}

}
