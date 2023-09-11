package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.LogoutController;
import controller.MemberRegisterController;
import controller.RegisterController;
import controller.BoardController;
import controller.BoardDetailController;
import controller.ChangePwdController;
import controller.ClassListController;
import controller.EditInfoController;
import controller.MemberDetailController;
import controller.MemberListController;
import spring.MemberDao;
import spring.ChangePasswordService;
import spring.ClassInfoDao;
import spring.ClassesRegisterService;
import spring.InstructorDao;
import spring.InstructorRegisterService;
import spring.AuthService;
import spring.MemberRegisterService;
import spring.StudioDao;
import spring.StudioRegisterService;
import spring.BoardDao;
import spring.BoardWriteService;


@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardWriteService boardWrtSvc;
	@Autowired
	private StudioDao studioDao;
	@Autowired
	private InstructorDao instructorDao;
	@Autowired
	private StudioRegisterService studioRegSvc;
	@Autowired
	private InstructorRegisterService instructorRegSvc;
	@Autowired
	private ClassesRegisterService classesRegSvc;
	@Autowired
	private ClassInfoDao classInfoDao;
	
	@Bean
	public MemberRegisterController memberregisterController() {
		MemberRegisterController controller = new MemberRegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	
	@Bean
	public MemberListController memberListController() {
		MemberListController controller = new MemberListController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public MemberDetailController memberDetailController() {
		MemberDetailController controller = new MemberDetailController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public BoardController boardController() {
		BoardController controller = new BoardController();
		controller.setBoardDao(boardDao);
		controller.setBoardWriteService(boardWrtSvc);
		return controller;
	}
	
	@Bean
	public BoardDetailController boardDetailController() {
		BoardDetailController controller = new BoardDetailController();
		controller.setBoardDao(boardDao);
		return controller;
	}
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setStudioRegisterService(studioRegSvc);
		controller.setStudioDao(studioDao);
		controller.setInstructorRegisterService(instructorRegSvc);
		controller.setInstructorDao(instructorDao);
		controller.setClassesRegisterService(classesRegSvc);
		return controller;
	}
	
	@Bean
	public ClassListController classListController() {
		ClassListController controller = new ClassListController();
		controller.setClassInfoDao(classInfoDao);
		controller.setStudioDao(studioDao);
		controller.setInstructorDao(instructorDao);
		return controller;
	}
	
	@Bean
	public EditInfoController editInfoController() {
		EditInfoController controller = new EditInfoController();
		controller.setMemberDao(memberDao);
		return controller;
	}

}
