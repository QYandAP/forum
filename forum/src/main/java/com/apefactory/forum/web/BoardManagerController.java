package com.apefactory.forum.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apefactory.forum.entity.Board;
import com.apefactory.forum.entity.Topic;
import com.apefactory.forum.service.ForumService;

@Controller
public class BoardManagerController extends BaseController {

	@Resource
	public ForumService forumService;

	@RequestMapping("boards")
	public ModelAndView listAllBoards() {
		ModelAndView mv = new ModelAndView();
		List<Board> boards = forumService.getAllBoard();
		mv.addObject("boards", boards);
		mv.setViewName("listAllBoards");
		return mv;
	}
	
	@RequestMapping("boards/boardtopics")
	public ModelAndView listAllBoardTopics(@RequestParam("boardId") int boardId){
		List<Topic> topics = forumService.getAllBoardTopics(boardId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("topics", topics);
		mv.setViewName("listBoardTopics");
		return mv;
	}
}
