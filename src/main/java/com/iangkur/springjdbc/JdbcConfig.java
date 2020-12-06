package com.iangkur.springjdbc;

import com.iangkur.springjdbc.dao.StudentDaoImpl;
import com.iangkur.springjdbc.dao.entities.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.iangkur.springjdbc.dao")
public class JdbcConfig {
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();

		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/myspringjdbc");
		ds.setUsername("root");
		ds.setPassword("");

		return ds;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriverManagerDataSource());

		return jdbcTemplate;
	}

/*	@Bean
	public StudentDaoImpl getStudentDao() {
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.setJdbcTemplate(getJdbcTemplate());
		return studentDao;
	}*/

	@Bean
	public Student getStudent() {
		return new Student();
	}
}
