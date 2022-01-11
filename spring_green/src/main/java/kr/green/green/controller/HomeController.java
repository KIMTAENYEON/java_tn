package kr.green.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		mv.setViewName("/main/home");
		//아래 코드는 연동 확인 후 지울 코드
		MemberVO user = memberService.test("qwe");
		System.out.println(user);
		return mv;
	}
	
}
