package com.ty.manytomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetStudentCourse {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student = entityManager.find(Student.class, 5);
		if (student != null) {
			System.out.println(" ");
			System.out.println("Student Name " + student.getName());
			System.out.println("Age " + student.getAge());
			System.out.println("------------------------------------");
			List<Course> courses = student.getCourse();
			for (Course course : courses) {
				System.out.println("Course Name " + course.getName());
				System.out.println("Duration " + course.getDuration());
				System.out.println("----------------------------------");
			}
		} else {
			System.out.println("No Student exists for given Id");
		}

	}

}
