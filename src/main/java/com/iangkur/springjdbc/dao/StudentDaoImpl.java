package com.iangkur.springjdbc.dao;

import com.iangkur.springjdbc.dao.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("getStudentDao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {

		// Insert query
		String query = "INSERT INTO student(id, name, address) VALUES(?, ?, ?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());

		return r;
	}

	@Override
	public int change(Student student) {
		// Update query
		String query = "UPDATE student SET name=?, address=? WHERE id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getAddress(), student.getId());
		return r;
	}

	@Override
	public int delete(int  studentId) {
		// Delete query
		String query = "DELETE FROM student WHERE id=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
		// Select single data
		String query = "SELECT * FROM student WHERE id=?";

		RowMapper<Student> rowMapper = new RowMapperImpl();

		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

		// RowMapper Interface er Anonymous object create koreo kora jay, eta korle RowMapperImpl class ar banate hobe na
/*		Student student = this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student st = new Student();

				st.setId(rs.getInt(1)); // first column id
				st.setName(rs.getString(2));
				st.setAddress(rs.getString(3));

				return st;
			}
		}, studentId);*/

		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// Select All Students
		String query = "SELECT * FROM student";

		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());

		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
