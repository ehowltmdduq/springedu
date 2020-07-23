package com.kh.portfolio.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.portfolio.member.SVC.MemberSVC;
import com.kh.portfolio.member.VO.MemberVO;

@Controller
@RequestMapping
public class LoginController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(LoginController.class);

	@Inject
	MemberSVC memberSVC;
	//로그인화면
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	//로그인처리
	@PostMapping("login")
	public String login(@RequestParam("id") String id,
			                @RequestParam("pw") String pw,
			                HttpSession session,
			                Model model) {
		logger.info("String login 호출");
		logger.info("id = " + id);
		logger.info("pw = " + pw);
		//1)회워id 존재 유무 확인
		MemberVO memberVO = memberSVC.listOneMember(id);
		//2)회원 id가 존재하지않는다면
		if(memberVO == null) {
			model.addAttribute("svr_msg", "가입된 회원정보가 없습니다");
			return "/member/loginForm";
		}else {
			//3)회원 id가 존재한다면
			//비밀번호가 일치하는 경우
			if(memberVO.getPw().equals(pw)) {
				session.setAttribute("member",memberVO);
				//비밀번호가 일치하지않는 경우
			}else {
				model.addAttribute("svr_msg", "비밀번호가 일치하지않습니다");
				return "/member/loginForm";
			}
		}
		memberSVC.login(id, pw);
		return "redirect:/";
	}
	//로그아웃
	@GetMapping(".logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
}
