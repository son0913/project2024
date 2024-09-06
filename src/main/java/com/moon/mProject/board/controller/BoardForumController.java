package com.moon.mProject.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moon.mProject.board.VO.ForumVO;
import com.moon.mProject.board.service.BoardForumService;

import ch.qos.logback.core.model.Model;

@Controller
public class BoardForumController {
	
	@Autowired
	private BoardForumService boardForumService;

	@GetMapping("/forumList")
	public String  moveForumList() {
		return "board/forum/forumList";
	}
	/*
	 * Get - Select 상세
	 * Post - Insert
	 * Put - Update
	 * delete - delete
	 * */
	@GetMapping("/forum") 
	public String getForum() {
		return "board/forum/forumForm";
	}
	
	@GetMapping("/forum/{idx}") 
	public String getForumDetail(@PathVariable("idx") int idx) {
		return "board/forum/forumForm";
	}
	
	@PostMapping("/forum") 
	public String postForum(ForumVO forumVo) {  
		boardForumService.insertForum(forumVo);
		//새글작성
		return "redirect:/forumList";
	}
}
