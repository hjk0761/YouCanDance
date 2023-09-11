package spring;

import java.time.LocalDateTime;

public class ClassInfo {
	
	private String studio_name;
	private String studio_locate;
	private String instructor_name;
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private String genre;
	private String difficulty;
	private String apply;
	
	public ClassInfo(String studio_name, String studio_locate, String instructor_name, LocalDateTime start_time, LocalDateTime end_time, String genre, String difficulty, String apply) {
		this.studio_name = studio_name;
		this.studio_locate = studio_locate;
		this.instructor_name = instructor_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.genre = genre;
		this.difficulty = difficulty;
		this.apply = apply;
	}
	
	public String getStudio_name() {
		return studio_name;
	}
	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	public String getStudio_locate() {
		return studio_locate;
	}
	public void setStudio_locate(String studio_locate) {
		this.studio_locate = studio_locate;
	}
	public String getInstructor_name() {
		return instructor_name;
	}
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
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
