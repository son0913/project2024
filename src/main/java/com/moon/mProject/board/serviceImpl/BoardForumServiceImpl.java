package com.moon.mProject.board.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.moon.mProject.board.VO.ForumVO;
import com.moon.mProject.board.mapper.BoardForumMapper;
import com.moon.mProject.board.service.BoardForumService;

public class BoardForumServiceImpl implements BoardForumService{
	
	@Autowired
	private BoardForumMapper boardForumMapper;

	@Override
	public void insertForum(ForumVO forumVo) {
		boardForumMapper.insertForum(forumVo);
	}

}
