package spring;

public class InstructorRegisterRequest {
	
	private String name;
	private String studio_name;
	private Long studio_id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudio_name() {
		return studio_name;
	}
	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	public Long getStudio_id() {
		return studio_id;
	}
	public void setStudio_id(Long studio_id) {
		this.studio_id = studio_id;
	}

}
