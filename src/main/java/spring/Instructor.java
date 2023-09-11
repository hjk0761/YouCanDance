package spring;

/*
	ID int auto_increment primary key,
    NAME varchar(100),
    STUDIO_ID int,
    foreign key (STUDIO_ID) references YouCanDance.STUDIO(ID)
*/

public class Instructor {
	
	private Long id;	
	private String name;
	private Long studio_id;
	
	public Instructor(String name, Long studio_id) {
		this.name = name;
		this.studio_id = studio_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStudio_id() {
		return studio_id;
	}

	public void setStudio_id(Long studio_id) {
		this.studio_id = studio_id;
	}

}
