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

public class StudioDao{
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Studio> memRowMapper = new RowMapper<Studio>() {
		@Override
		public Studio mapRow(ResultSet rs, int rowNum) throws SQLException{
			Studio studio= new Studio(
				rs.getString("NAME"),
				rs.getString("LOCATE"),
				rs.getString("INFO"));
			studio.setId(rs.getLong("ID"));
			return studio;
		}
	};
	
	public StudioDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Studio> list(){
		List<Studio> results = jdbcTemplate.query("select * from STUDIO", memRowMapper);
		return results;
	}
	
	public int count() {
	Integer count = jdbcTemplate.queryForObject(
			"select count(*) from STUDIO", Integer.class);
	return count;
	}
	
	public void update(Studio studio) {
		jdbcTemplate.update(
				"update STUDIO set NAME = ?, LOCATE = ?, INFO = ? where ID = ?",
				studio.getName(), studio.getLocate(), studio.getInfo(), studio.getId());
	}
	
	public void insert(final Studio studio) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException{
				PreparedStatement pstmt = con.prepareStatement(
						"insert into STUDIO (NAME, LOCATE, INFO) "+
				"values (?, ?, ?)",
				new String[] {"ID"} );
				pstmt.setString(1, studio.getName());
				pstmt.setString(2, studio.getLocate());
				pstmt.setString(3, studio.getInfo());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		studio.setId(keyValue.longValue());
	}
	
	public Studio selectById(Long studioId){
		List<Studio> results = jdbcTemplate.query(
				"select * from STUDIO where ID = ?", memRowMapper, studioId);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<Studio> selectByName(String studioName){
		String wrappedName = "%" + studioName + "%";
		List<Studio> results = jdbcTemplate.query(
				"select * from STUDIO where NAME like ?", memRowMapper, wrappedName);
		return results.isEmpty() ? null : results;
	}
	
	public List<Studio> selectByLocate(String studioLocate){
		String wrappedLocate = "%" + studioLocate + "%";
		List<Studio> results = jdbcTemplate.query(
				"select * from STUDIO where LOCATE like ?", memRowMapper, wrappedLocate);
		return results.isEmpty() ? null : results;
	}
	
}
