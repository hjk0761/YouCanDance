package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.ChangePasswordService;
import spring.ClassInfoDao;
import spring.ClassesDao;
import spring.ClassesRegisterService;
import spring.InstructorDao;
import spring.InstructorRegisterService;
import spring.MemberDao;
import spring.MemberRegisterService;
import spring.StudioDao;
import spring.StudioRegisterService;
import spring.AuthService;

@Configuration
@EnableTransactionManagement
public class RegisterConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/YouCanDance?useSSL=False&characterEncoding=utf8");
		ds.setUsername("project");
		ds.setPassword("project");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public AuthService authService() {
		AuthService authService = new AuthService();
		authService.setMemberDao(memberDao());
		return authService;
	}
	
	@Bean
	public StudioDao studioDao() {
		return new StudioDao(dataSource());
	}
	
	@Bean
	public StudioRegisterService studioRegSvc() {
		return new StudioRegisterService(studioDao());
	}
	
	@Bean
	public InstructorDao instructorDao() {
		return new InstructorDao(dataSource());
	}
	
	@Bean
	public InstructorRegisterService instructorRegSvc() {
		return new InstructorRegisterService(instructorDao());
	}
	
	@Bean
	public ClassesDao classesDao() {
		return new ClassesDao(dataSource());
	}
	
	@Bean
	public ClassesRegisterService classesRegSvc() {
		return new ClassesRegisterService(classesDao());
	}
	
	@Bean
	public ClassInfoDao classInfoDao() {
		return new ClassInfoDao(dataSource());
	}

}
