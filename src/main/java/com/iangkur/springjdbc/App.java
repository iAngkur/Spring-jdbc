package com.iangkur.springjdbc;

import com.iangkur.springjdbc.dao.StudentDao;
import com.iangkur.springjdbc.dao.StudentDaoImpl;
import com.iangkur.springjdbc.dao.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
/*		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

		 //Just checking. it's not a good way to deal with DB. We'll use class

		// Insert query
		String query = "INSERT INTO student(id, name, address) VALUES(?, ?, ?)";

		// Fire query
		int result = template.update(query, 1507003, "Sohana Akhter", "Rajshahi");
		System.out.println("number of record inserted..." + result);*/


		// parent class e child class er object rakhsi
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// Insert data
/*		Student student = new Student(1507001, "Asifur Rahman", "Jessor");
		int result = studentDao.insert(student);
		System.out.printf("Student added " + result);*/

/*		// Update data
		Student student = new Student();
		student.setId(1507002);
		student.setName("Angkur");
		student.setAddress("Khulna");

		int result = studentDao.change(student);
		System.out.println("Updated row " + result);*/


/*	    // Delete data
		int result = studentDao.delete(1507003);
		System.out.println("Deleted row " + result);*/

		// Select Single Student
/*		Student student = studentDao.getStudent(1507002);
		System.out.println(student);*/


		// Select All Students
		List<Student> students = studentDao.getAllStudents();
		for(Student s : students) {
			System.out.println(s);
		}
	}
}
