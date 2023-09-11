package spring;

public class ClassesRegisterRequest {
	
	private String studio_name;
	private Long studio_id;
	private String instructor_name;
	private Long instructor_id;
	private String start_time;
	private String end_time;
	private String genre;
	private String difficulty;
	private String apply;
	
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
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
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
	public String getStudio_name() {
		return studio_name;
	}
	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	public String getInstructor_name() {
		return instructor_name;
	}
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	
}
