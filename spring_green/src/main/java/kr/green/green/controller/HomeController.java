package kr.green.green.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		mv.setViewName("/main/home");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO user) {
		MemberVO loginUser = memberService.login(user);
		if(loginUser == null) {
			mv.setViewName("redirect:/login");
		}else {
			loginUser.setMe_auto_login(user.getMe_auto_login());
			mv.addObject("user", loginUser);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		boolean isSignup = memberService.signup(user);
		if(isSignup) {
			mv.setViewName("redirect:/");			
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {	
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user != null) {
			//????????? ?????? ?????? ????????? ??????
			request.getSession().removeAttribute("user");
			//request??? ?????? ?????? ??? ????????? loginCookie ????????? ?????????
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			//loginCookie ????????? ????????? => ??????????????? ????????? ?????????????????? ??????
			if(cookie != null) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				//??????????????? ????????? ?????? ?????? ???????????? none??? ????????????, ??????????????? ?????????????????? ??????
				user.setMe_session_id("none");
				user.setMe_session_limit(new Date());
				memberService.updateAutoLogin(user);
			}
		}
		mv.setViewName("redirect:/");	
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/idCheck")
	public String idCheck(String me_id) {	
		return memberService.idCheck(me_id);
	}
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(ModelAndView mv, HttpServletRequest request, MemberVO input) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		MemberVO newUser = memberService.updateMember(input, user);
		if(newUser != null)
			request.getSession().setAttribute("user", newUser);
		mv.setViewName("/member/mypage");	
		return mv;
	}
	@RequestMapping(value = "/member/find")
	public ModelAndView memberFind(ModelAndView mv, HttpServletRequest request, MemberVO input) {
		mv.setViewName("/member/find");	
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/member/find/id")
	public String memberFindId(@RequestBody MemberVO member) {
		return memberService.findId(member);
	}
	@ResponseBody
	@RequestMapping(value = "/member/find/pw")
	public String memberFindPw(@RequestBody MemberVO member) {
		return memberService.findPw(member);
	}
}
