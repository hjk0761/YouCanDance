package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ClassInfoDao{
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<ClassInfo> memRowMapper = new RowMapper<ClassInfo>() {
		@Override
		public ClassInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
			ClassInfo classInfo= new ClassInfo(
				rs.getString("STUDIO_NAME"),
				rs.getString("STUDIO_LOCATE"),
				rs.getString("INSTRUCTOR_NAME"),
				rs.getTimestamp("START_TIME").toLocalDateTime(),
				rs.getTimestamp("END_TIME").toLocalDateTime(),
				rs.getString("GENRE"),
				rs.getString("DIFFICULTY"),
				rs.getString("APPLY"));
			return classInfo;
		}
	};
	
	public ClassInfoDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<ClassInfo> list(){
		List<ClassInfo> results = jdbcTemplate.query("select STUDIO.NAME AS STUDIO_NAME, STUDIO.LOCATE AS STUDIO_LOCATE, INSTRUCTOR.NAME AS INSTRUCTOR_NAME, CLASS.START_TIME, CLASS.END_TIME, CLASS.GENRE, CLASS.DIFFICULTY, CLASS.APPLY "
				+ "from STUDIO, INSTRUCTOR, CLASS "
				+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID", memRowMapper);
		return results;
	}
	
	public int count() {
	Integer count = jdbcTemplate.queryForObject(
			"select count( * ) "
					+ "from STUDIO, INSTRUCTOR, CLASS "
					+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID", Integer.class);
	return count;
	}
	
	public List<ClassInfo> selectByStudioId(Long studioId){
		List<ClassInfo> results = jdbcTemplate.query(
				"select STUDIO.NAME AS STUDIO_NAME, STUDIO.LOCATE AS STUDIO_LOCATE, INSTRUCTOR.NAME AS INSTRUCTOR_NAME, CLASS.START_TIME, CLASS.END_TIME, CLASS.GENRE, CLASS.DIFFICULTY, CLASS.APPLY "
						+ "from STUDIO, INSTRUCTOR, CLASS "
						+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID AND STUDIO.ID = ?", memRowMapper, studioId);
		return results.isEmpty() ? null : results;
	}
	
	public List<ClassInfo> selectByInstructorId(Long instructorId){
		List<ClassInfo> results = jdbcTemplate.query(
				"select STUDIO.NAME AS STUDIO_NAME, STUDIO.LOCATE AS STUDIO_LOCATE, INSTRUCTOR.NAME AS INSTRUCTOR_NAME, CLASS.START_TIME, CLASS.END_TIME, CLASS.GENRE, CLASS.DIFFICULTY, CLASS.APPLY "
						+ "from STUDIO, INSTRUCTOR, CLASS "
						+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID AND INSTRUCTOR.ID = ?", memRowMapper, instructorId);
		return results.isEmpty() ? null : results;
	}
	
	public List<ClassInfo> selectByLocate(String locate){
		String wrappedlocate = "%" + locate + "%";
		List<ClassInfo> results = jdbcTemplate.query(
				"select STUDIO.NAME AS STUDIO_NAME, STUDIO.LOCATE AS STUDIO_LOCATE, INSTRUCTOR.NAME AS INSTRUCTOR_NAME, CLASS.START_TIME, CLASS.END_TIME, CLASS.GENRE, CLASS.DIFFICULTY, CLASS.APPLY "
						+ "from STUDIO, INSTRUCTOR, CLASS "
						+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID AND STUDIO.LOCATE like ?", memRowMapper, wrappedlocate);
		return results.isEmpty() ? null : results;
	}
	
	public List<ClassInfo> selectByTime(LocalDateTime start_time, LocalDateTime end_time){
		List<ClassInfo> results = jdbcTemplate.query(
				"select STUDIO.NAME AS STUDIO_NAME, STUDIO.LOCATE AS STUDIO_LOCATE, INSTRUCTOR.NAME AS INSTRUCTOR_NAME, CLASS.START_TIME, CLASS.END_TIME, CLASS.GENRE, CLASS.DIFFICULTY, CLASS.APPLY "
						+ "from STUDIO, INSTRUCTOR, CLASS "
						+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID AND CLASS.START_TIME BETWEEN ? AND ? " +
				"order by START_TIME desc",memRowMapper, start_time, end_time);
		return results;
	}
	
	public List<ClassInfo> selectByGenre(String genre){
		List<ClassInfo> results = jdbcTemplate.query(
				"select STUDIO.NAME AS STUDIO_NAME, STUDIO.LOCATE AS STUDIO_LOCATE, INSTRUCTOR.NAME AS INSTRUCTOR_NAME, CLASS.START_TIME, CLASS.END_TIME, CLASS.GENRE, CLASS.DIFFICULTY, CLASS.APPLY "
						+ "from STUDIO, INSTRUCTOR, CLASS "
						+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID AND CLASS.GENRE = ?", memRowMapper, genre);
		return results.isEmpty() ? null : results;
	}
	
	public List<ClassInfo> selectByDifficulty(String difficulty){
		List<ClassInfo> results = jdbcTemplate.query(
				"select STUDIO.NAME AS STUDIO_NAME, STUDIO.LOCATE AS STUDIO_LOCATE, INSTRUCTOR.NAME AS INSTRUCTOR_NAME, CLASS.START_TIME, CLASS.END_TIME, CLASS.GENRE, CLASS.DIFFICULTY, CLASS.APPLY "
						+ "from STUDIO, INSTRUCTOR, CLASS "
						+ "where CLASS.STUDIO_ID = STUDIO.ID AND CLASS.INSTRUCTOR_ID = INSTRUCTOR.ID AND CLASS.DIFFICULTY = ?", memRowMapper, difficulty);
		return results.isEmpty() ? null : results;
	}
	
}
