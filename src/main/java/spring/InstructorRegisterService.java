package spring;

public class InstructorRegisterService {
	private InstructorDao instructorDao;
	
	public InstructorRegisterService(InstructorDao instructorDao) {
		this.instructorDao = instructorDao;
	}
	
	public Long regist(InstructorRegisterRequest req) {
		Instructor newinstructor = new Instructor(req.getName(), req.getStudio_id());
		instructorDao.insert(newinstructor);
		return newinstructor.getId();
	}

}
