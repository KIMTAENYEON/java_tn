package kr.green.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.AdminService;
import kr.green.green.vo.MemberVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin/member/modify")
	public ModelAndView memberListGet(ModelAndView mv, HttpServletRequest request) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if(user == null || !user.getMe_authority().equals("슈퍼 관리자")) {
			mv.setViewName("redirect:/");
		}else {
			List<MemberVO> list = adminService.getMemberList();
			mv.addObject("list", list);
			mv.setViewName("/admin/member/modify");
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/admin/change/authority")
	public boolean adminChangeAuthority(@RequestBody MemberVO member, HttpServletRequest request) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		return adminService.changeAuthority(member, user);
	}
}
