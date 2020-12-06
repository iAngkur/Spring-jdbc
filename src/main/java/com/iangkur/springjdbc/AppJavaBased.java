package com.iangkur.springjdbc;

import com.iangkur.springjdbc.dao.StudentDao;
import com.iangkur.springjdbc.dao.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppJavaBased {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("getStudentDao", StudentDao.class);

//		Student student = new Student();
		Student student = context.getBean("getStudent", Student.class);
		student.setId(1507004);
		student.setName("Rafi");
		student.setAddress("Dhaka");

		int result = studentDao.insert(student);

		System.out.println("Row added " + result);
	}
}
