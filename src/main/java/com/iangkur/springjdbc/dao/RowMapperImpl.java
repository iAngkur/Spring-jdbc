package com.iangkur.springjdbc.dao;

import com.iangkur.springjdbc.dao.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student student = new Student();

		student.setId(rs.getInt(1)); // first column id
		student.setName(rs.getString(2));
		student.setAddress(rs.getString(3));

		return student;
	}
}
