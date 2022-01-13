package kr.green.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list", method=RequestMethod.GET )
	public ModelAndView boardListGet(ModelAndView mv) {
		List<BoardVO> list = boardService.getBoardList("일반");
		//System.out.println(list);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/detail", method=RequestMethod.GET )
	public ModelAndView boardDetailGet(ModelAndView mv, Integer bd_num) {
		//System.out.println(bd_num);
		BoardVO board = boardService.getBoard(bd_num);
		//System.out.println(board);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	@RequestMapping(value = "/board/register", method=RequestMethod.GET )
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value = "/board/register", method=RequestMethod.POST )
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		board.setBd_type("일반");
		//System.out.println(board);
		boardService.registerBoard(board, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
