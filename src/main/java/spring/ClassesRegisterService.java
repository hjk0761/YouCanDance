package spring;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClassesRegisterService {
	private ClassesDao classesDao;
	
	public ClassesRegisterService(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}
	
	public Long regist(ClassesRegisterRequest req) {
		Classes newclasses = new Classes(req.getStudio_id(), req.getInstructor_id(), LocalDateTime.parse(req.getStart_time(), DateTimeFormatter.ISO_DATE_TIME), LocalDateTime.parse(req.getEnd_time(), DateTimeFormatter.ISO_DATE_TIME), req.getGenre(), req.getDifficulty(), req.getApply());
		classesDao.insert(newclasses);
		return newclasses.getId();
	}

}
