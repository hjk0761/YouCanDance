package spring;

import java.time.LocalDateTime;
/*
ID int auto_increment primary key,
    SUBJECT varchar(255),
    CONTENT varchar(1000),
    NAME varchar(100),
    REGDATE datetime,
    READCOUNT int
*/

public class Board {
	
	private Long id;
	private String subject;
	private String content;
	private String name;
	private LocalDateTime regdate;
	private Long readCount;
	
	public Board(String subject, String content, String name, LocalDateTime regdate, Long readCount) {
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.regdate = regdate;
		this.readCount = readCount;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getRegdate() {
		return regdate;
	}
	
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	
	public Long getReadCount() {
		return readCount;
	}
	
	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}
	
}
