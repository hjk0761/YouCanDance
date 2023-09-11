package controller;

import org.springframework.validation.Errors;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring.ClassesRegisterRequest;
import spring.ClassesRegisterService;
import spring.Instructor;
import spring.InstructorDao;
import spring.InstructorRegisterRequest;
import spring.InstructorRegisterService;
import spring.Studio;
import spring.StudioDao;
import spring.StudioRegisterRequest;
import spring.StudioRegisterService;

@Controller
public class RegisterController {
	
	private StudioDao studioDao;
	private InstructorDao instructorDao;
	private StudioRegisterService studioRegisterService;
	private InstructorRegisterService instructorRegisterService;
	private ClassesRegisterService classesRegisterService;
	
	
	public void setStudioDao(StudioDao studioDao) {
		this.studioDao = studioDao;
	}
	
	public void setInstructorDao(InstructorDao instructorDao) {
		this.instructorDao = instructorDao;
	}
	
	public void setStudioRegisterService(StudioRegisterService studioRegisterService) {
		this.studioRegisterService = studioRegisterService;
	}
	
	public void setInstructorRegisterService(InstructorRegisterService instructorRegisterService) {
		this.instructorRegisterService = instructorRegisterService;
	}
	
	public void setClassesRegisterService(ClassesRegisterService classesRegisterService) {
		this.classesRegisterService = classesRegisterService;
	}
	
	@GetMapping("/register/step0")
	public String handleStep0() {
		return "register/step0";
	}
	
	@GetMapping("/register/studio")
	public String handleStudio(Model model) {
		model.addAttribute("studioRegisterRequest", new StudioRegisterRequest());
		return "register/studio";
	}
	
	@PostMapping("register/studio")
	public String handleRegister(StudioRegisterRequest regReq, Errors errors) {
		new StudioRegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors()) {
			return "register/studio";
		}
		studioRegisterService.regist(regReq);
		return "register/step0";
	}

	@GetMapping("/register/instructor")
	public String handleInstructor(Model model) {
		model.addAttribute("instructorRegisterRequest", new InstructorRegisterRequest());
		return "register/instructor";
	}
	
	@GetMapping("/register/studioPop")
	public void studioPopGET(Model model) throws Exception{
		int count = studioDao.count();
		model.addAttribute("count", count);
		List<Studio> studios = studioDao.list();
		model.addAttribute("studios", studios);
		return ;
	}
	
	@PostMapping("/register/instructor")
	public String handleInstructorRegister(InstructorRegisterRequest regReq, Errors errors) {
		new InstructorRegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors()) {
			return "register/instructor";
		}
		instructorRegisterService.regist(regReq);
		return "register/step0";
	}
	
	@GetMapping("/register/classes")
	public String handleClasses(Model model) {
		model.addAttribute("classesRegisterRequest", new ClassesRegisterRequest());
		return "register/classes";
	}
	
	@GetMapping("/register/instructorPop")
	public void instructorPopGET(Model model) throws Exception{
		int count = instructorDao.count();
		model.addAttribute("count", count);
		List<Instructor> instructors = instructorDao.list();
		model.addAttribute("instructors", instructors);
		return ;
	}
	
	@PostMapping("/register/classes")
	public String handleClassesRegister(ClassesRegisterRequest regReq, Errors errors) {
		new ClassesRegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors()) {
			return "register/classes";
		}
		classesRegisterService.regist(regReq);
		return "register/step0";
	}

}
