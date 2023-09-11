package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.AuthInfo;
import spring.Member;
import spring.MemberDao;

@Controller
public class EditInfoController {
	
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@GetMapping("/edit/info")
	public String detail(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if (authInfo == null){
			return "redirect:/login";
		}
		Member member = memberDao.selectById(authInfo.getId());
		if (member == null) {
			return "redirect:/login";
		}
		model.addAttribute("member", member);
		return "edit/info";
	}

}
