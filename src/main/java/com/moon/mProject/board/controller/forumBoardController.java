package com.moon.mProject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class forumBoardController {

	@GetMapping("/forumList")
	public ModelAndView moveForumList() {
		ModelAndView modelAndView = new ModelAndView("board/forum/forumList");
		return modelAndView;
	}
	/*
	 * Get - Select 상세
	 * Post - Insert
	 * Put - Update
	 * delete - delete
	 * */
	@GetMapping("/forum") 
	public ModelAndView getForum() {
		ModelAndView modelAndView = new ModelAndView("board/forum/forumDetail");
		return modelAndView;
	}
	
	@PostMapping("/forum") 
	public ModelAndView postForum() {
		ModelAndView modelAndView = new ModelAndView("board/forum/forumDetail");
		return modelAndView;
	}
}
