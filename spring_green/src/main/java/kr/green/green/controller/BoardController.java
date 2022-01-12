package kr.green.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET )
	public ModelAndView boardListGet(ModelAndView mv) {
		List<BoardVO> list = boardService.getBoardList("일반");
		//System.out.println(list);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/detail", method=RequestMethod.GET )
	public ModelAndView detailGet(ModelAndView mv, Integer bd_num) {
		//System.out.println(bd_num);
		BoardVO board = boardService.getBoard(bd_num);
		//System.out.println(board);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
}
