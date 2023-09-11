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

public class BoardDao{
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Board> memRowMapper = new RowMapper<Board>() {
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException{
			Board board = new Board(
				rs.getString("SUBJECT"),
				rs.getString("CONTENT"),
				rs.getString("NAME"),
				rs.getTimestamp("REGDATE").toLocalDateTime(),
				rs.getLong("READCOUNT"));
			board.setId(rs.getLong("ID"));
			return board;
		}
	};
	
	public BoardDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Board> list(){
		List<Board> results = jdbcTemplate.query("select * from BOARD", memRowMapper);
		return results;
	}
	
	public int count() {
	Integer count = jdbcTemplate.queryForObject(
			"select count(*) from BOARD", Integer.class);
	return count;
	}
	
	public void insert(final Board board) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException{
				PreparedStatement pstmt = con.prepareStatement(
						"insert into BOARD (SUBJECT, CONTENT, NAME, REGDATE, READCOUNT) "+
				"values (?, ?, ?, ?, 0)",
				new String[] {"ID"} );
				pstmt.setString(1, board.getSubject());
				pstmt.setString(2, board.getContent());
				pstmt.setString(3, board.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(board.getRegdate()));
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		board.setId(keyValue.longValue());
		board.setReadCount((long) 0);
	}
	
	public Board selectById(Long memId){
		List<Board> results = jdbcTemplate.query(
				"select * from BOARD where ID = ?", memRowMapper, memId);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Board updateReadCount(Board board) {
		jdbcTemplate.update(
				"update BOARD set READCOUNT = READCOUNT + 1 where id = ?", board.getId());
		return selectById(board.getId());
	}
}
