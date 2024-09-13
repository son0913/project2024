package com.moon.mProject.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.moon.mProject.board.VO.ForumVO;
import com.moon.mProject.board.service.BoardForumService;

@RestController
public class BoardForumController {
	
	@Autowired
	private BoardForumService boardForumService;

	/*
	 * Get - Select 상세
	 * Post - Insert
	 * Put - Update
	 * delete - delete
	 * */
	/** 뷰 처리 */
	@GetMapping("/forumForm") 
	public ModelAndView getForum() {
		ModelAndView andView = new ModelAndView("/board/forum/forumForm");
		return andView;
	}
	
	@GetMapping("/forum")
	public ModelAndView getForumList(Model model) {
		ModelAndView andView = new ModelAndView("/board/forum/forumList");
		return andView;
	}
	
	@GetMapping("/forum/{idx}") 
	public ModelAndView getForumDetail(@PathVariable int idx) {
		ModelAndView andView = new ModelAndView("/board/forum/forumDetail");
		return andView;
	}
	
	@GetMapping("/forum/{page}/{size}") 
	public ModelAndView getForumList2(@PathVariable int page, @PathVariable int size) {
		ModelAndView andView = new ModelAndView("/board/forum/forumList");
		return andView;
		//new RedirectView(null)
	}
	
	/** 기능 처리 */
	//새글작성 POST(insert)
	@PostMapping("/forum") 
	public ResponseEntity<Map<String, Object>> postForum(ForumVO forumVo) {  
		HashMap<String, Object> resmap = new HashMap<>();
		forumVo.setIdx(boardForumService.selectMaxIdx());
		boardForumService.insertForum(forumVo);
		//새글작성
		//ModelAndView andView = new ModelAndView("/board/forum/forumList");
		//return andView;
		resmap.put("data", "success");
		return ResponseEntity.ok(resmap);
	}
	
	@PutMapping("/forum") 
	public ResponseEntity<Map<String, Object>> putForum(@RequestParam Map<String, Object> map) {  
		HashMap<String, Object> resmap = new HashMap<>();
		boardForumService.updatetForum(map);
		//새글작성
		resmap.put("data", "success");
		return ResponseEntity.ok(resmap);
	}
	
	@DeleteMapping("/forum") 
	public ResponseEntity<Map<String, Object>> deleteForum(@RequestParam Map<String, Object> map) {  
		HashMap<String, Object> resmap = new HashMap<>();
		boardForumService.deleteForum(map); 
		//새글작성
		resmap.put("data", "success");
		return ResponseEntity.ok(resmap);
	}
	
	@PostMapping("/forumList")
	public ResponseEntity<Map<String, Object>>  getForumList(
			@RequestParam(required = false, defaultValue = "1") int page, //요청된 페이지 번호
			@RequestParam(required = false, defaultValue = "10") int size //한 페이지에 표시할 게시글 수
			//false를 하게 된다면, null 에러를 보내지 않게 된다.
	) {
		/**
		 *  LIMIT 10: 한 페이지에 보여줄 게시글 수를 10개로 제한.
			OFFSET 10: 앞의 10개 게시글을 건너뜁니다. (1페이지는 09, 2페이지는 1019)
		 * */
		System.out.println("ForumList");
		int offset = (page-1) * size;
		int totalPage = boardForumService.selectForumTotal();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("size", size); 
		map.put("offset", offset); 
		
		List<ForumVO> forumVO = boardForumService.selectForumList(map);

		map.clear();
		map.put("ForumVO", forumVO);
		map.put("totalPage", (int)Math.ceil((double) totalPage / size));
		
		
		//map.put("ForumVO", forumVO);
		//return forumVO;
		return ResponseEntity.ok(map);
	}
	
	
	@PostMapping("/forumDetail")
	public ResponseEntity<Map<String, Object>> selectForumDetail(@RequestParam int idx){
		HashMap<String, Object> map = new HashMap<>();
		List<ForumVO> forumVo = boardForumService.selectForumDetail(idx);
		map.put("forumVO", forumVo);
		return ResponseEntity.ok(map);
	}
}
