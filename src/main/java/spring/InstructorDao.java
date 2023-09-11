package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class InstructorDao{
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Instructor> memRowMapper = new RowMapper<Instructor>() {
		@Override
		public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException{
			Instructor instructor = new Instructor(
				rs.getString("NAME"),
				rs.getLong("STUDIO_ID"));
			instructor.setId(rs.getLong("ID"));
			return instructor;
		}
	};
	
	public InstructorDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Instructor> list(){
		List<Instructor> results = jdbcTemplate.query("select * from INSTRUCTOR", memRowMapper);
		return results;
	}
	
	public int count() {
	Integer count = jdbcTemplate.queryForObject(
			"select count(*) from INSTRUCTOR", Integer.class);
	return count;
	}
	
	public void update(Instructor instructor) {
		jdbcTemplate.update(
				"update INSTRUCTOR set NAME = ?, STUDIO_ID = ? where ID = ?",
				instructor.getName(), instructor.getStudio_id(), instructor.getId());
	}
	
	public void insert(final Instructor instructor) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException{
				PreparedStatement pstmt = con.prepareStatement(
						"insert into INSTRUCTOR (NAME, STUDIO_ID) "+
				"values (?, ?)",
				new String[] {"ID"} );
				pstmt.setString(1, instructor.getName());
				pstmt.setLong(2, instructor.getStudio_id());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		instructor.setId(keyValue.longValue());
	}
	
	public Instructor selectById(Long memId){
		List<Instructor> results = jdbcTemplate.query(
				"select * from INSTRUCTOR where ID = ?", memRowMapper, memId);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Instructor selectByName(String name){
		List<Instructor> results = jdbcTemplate.query(
				"select * from INSTRUCTOR where NAME = ?", memRowMapper, name);
		return results.isEmpty() ? null : results.get(0);
	}
	
}
