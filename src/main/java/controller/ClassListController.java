package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import spring.ClassInfo;
import spring.ClassInfoDao;
import spring.Instructor;
import spring.InstructorDao;
import spring.Studio;
import spring.StudioDao;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClassListController {
	
	private StudioDao studioDao;
	private InstructorDao instructorDao;
	private ClassInfoDao classInfoDao;
	
	public void setStudioDao(StudioDao studioDao) {
		this.studioDao = studioDao;
	}
	
	public void setInstructorDao(InstructorDao instructorDao) {
		this.instructorDao = instructorDao;
	}
	
	public void setClassInfoDao(ClassInfoDao classInfoDao) {
		this.classInfoDao = classInfoDao;
	}
	
	@RequestMapping("/classes/list")
	public String list(ClassListCommand classListCommand, ListCommand listCommand, Errors errors, Model model) {
		int count = classInfoDao.count();
		model.addAttribute("count", count);
		List<ClassInfo> results = new ArrayList<>();
		if (errors.hasErrors()) {
			return "redirect:/classes/list";
		}
		else if (classListCommand.getSearch_category() != null && classListCommand.getSearch_keyword() != "") {
			switch(classListCommand.getSearch_category()) {
			case "studio_name":
				Studio studio = studioDao.selectByName(classListCommand.getSearch_keyword()).get(0);
				results = classInfoDao.selectByStudioId(studio.getId());
				break;
			case "studio_locate":
				results = classInfoDao.selectByLocate(classListCommand.getSearch_keyword());
				break;
			case "instructor_name":
				Instructor instructor = instructorDao.selectByName(classListCommand.getSearch_keyword());
				results = classInfoDao.selectByInstructorId(instructor.getId());
				break;
			case "genre":
				results = classInfoDao.selectByGenre(classListCommand.getSearch_keyword());
				break;
			case "difficulty":
				results = classInfoDao.selectByDifficulty(classListCommand.getSearch_keyword());
				break;
			}
		}
		else if (listCommand.getFrom() != null && listCommand.getTo() != null) {
			results = classInfoDao.selectByTime(listCommand.getFrom(), listCommand.getTo());
		}
		else {
			List<ClassInfo> classInfos = classInfoDao.list();
			model.addAttribute("classInfos", classInfos);
			return "classes/list";
		}
		model.addAttribute("results", results);
		return "classes/list";
	}

}
