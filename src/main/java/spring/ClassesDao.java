package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ClassesDao{
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Classes> memRowMapper = new RowMapper<Classes>() {
		@Override
		public Classes mapRow(ResultSet rs, int rowNum) throws SQLException{
			Classes classes = new Classes(
				rs.getLong("STUDIO_ID"),
				rs.getLong("INSTRUCTOR_ID"),
				rs.getTimestamp("START_TIME").toLocalDateTime(),
				rs.getTimestamp("END_TIME").toLocalDateTime(),
				rs.getString("GENRE"),
				rs.getString("DIFFICULTY"),
				rs.getString("APPLY"));
			classes.setId(rs.getLong("ID"));
			return classes;
		}
	};
	
	public ClassesDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Classes> list(){
		List<Classes> results = jdbcTemplate.query("select * from CLASS", memRowMapper);
		return results;
	}
	
	public int count() {
	Integer count = jdbcTemplate.queryForObject(
			"select count(*) from CLASS", Integer.class);
	return count;
	}
	
	public void update(Classes classes) {
		jdbcTemplate.update(
				"update CLASS set STUDIO_ID = ?, INSTRUCTOR_ID = ?, START_TIME = ?, END_TIME = ?, GENRE = ?, DIFFICULTY = ?, APPLY = ? where ID = ?",
				classes.getStudio_id(), classes.getInstructor_id(), classes.getStart_time(), classes.getEnd_time(), classes.getGenre(), classes.getDifficulty(), classes.getApply(), classes.getId());
	}
	
	public void insert(final Classes classes) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException{
				PreparedStatement pstmt = con.prepareStatement(
						"insert into CLASS (STUDIO_ID, INSTRUCTOR_ID, START_TIME, END_TIME, GENRE, DIFFICULTY, APPLY) "+
				"values (?, ?, ?, ?, ?, ?, ?)",
				new String[] {"ID"} );
				pstmt.setLong(1, classes.getStudio_id());
				pstmt.setLong(2, classes.getInstructor_id());
				pstmt.setTimestamp(3, Timestamp.valueOf(classes.getStart_time()));
				pstmt.setTimestamp(4, Timestamp.valueOf(classes.getEnd_time()));
				pstmt.setString(5, classes.getGenre());
				pstmt.setString(6, classes.getDifficulty());
				pstmt.setString(7, classes.getApply());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		classes.setId(keyValue.longValue());
	}
	
	public Classes selectById(Long memId){
		List<Classes> results = jdbcTemplate.query(
				"select * from CLASS where ID = ?", memRowMapper, memId);
		return results.isEmpty() ? null : results.get(0);
	}
	
}
