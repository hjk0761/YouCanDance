package spring;

/*
	ID int auto_increment primary key,
    NAME varchar(100),
    LOCATE varchar(255),
    INFO varchar(255)
*/

public class Studio {
	
	private Long id;
	private String name;
	private String locate;
	private String info;
	
	public Studio(String name, String locate, String info) {
		this.name = name;
		this.locate = locate;
		this.info = info;
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

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
