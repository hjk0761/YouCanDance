package spring;

import java.time.LocalDateTime;

/*
	ID int auto_increment primary key,
	STUDIO_ID int,
	INSTRUCTOR_ID int,
    START_TIME datetime,
    END_TIME datetime,
    GENRE varchar(100),
    DIFFICULTY varchar(100),
    APPLY varchar(255),
    foreign key (STUDIO_ID) references YouCanDance.STUDIO(ID),
    foreign key (INSTRUCTOR_ID) references YouCanDance.INSTRUCTOR(ID)
*/

public class Classes {
	
	private Long id;
	private Long studio_id;
	private Long instructor_id;
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private String genre;
	private String difficulty;
	private String apply;
	
	public Classes(Long studio_id, Long instructor_id, LocalDateTime start_time, LocalDateTime end_time, String genre, String difficulty, String apply) {
		this.studio_id = studio_id;
		this.instructor_id = instructor_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.genre = genre;
		this.difficulty = difficulty;
		this.apply = apply;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudio_id() {
		return studio_id;
	}

	public void setStudio_id(Long studio_id) {
		this.studio_id = studio_id;
	}

	public Long getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(Long instructor_id) {
		this.instructor_id = instructor_id;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getApply() {
		return apply;
	}

	public void setApply(String apply) {
		this.apply = apply;
	}

}
