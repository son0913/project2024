package com.moon.mProject.board.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moon.mProject.board.VO.ForumVO;
import com.moon.mProject.board.mapper.BoardForumMapper;
import com.moon.mProject.board.service.BoardForumService;

@Service
public class BoardForumServiceImpl implements BoardForumService{
	
	@Autowired
	private BoardForumMapper boardForumMapper;

	@Override
	public int selectMaxIdx() {
		// TODO Auto-generated method stub
		return boardForumMapper.selectMaxIdx();
	}

	@Override
	public void insertForum(ForumVO forumVo) {
		boardForumMapper.insertForum(forumVo);
	}

	@Override
	public List<ForumVO> selectForumList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return boardForumMapper.selectForumList(map);
	}

	@Override
	public int selectForumTotal() {
		// TODO Auto-generated method stub
		return boardForumMapper.selectForumTotal();
	}

	@Override
	public List<ForumVO> selectForumDetail(int idx) {
		// TODO Auto-generated method stub
		return boardForumMapper.selectForumDetail(idx);
	}

	@Override
	public void updatetForum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		boardForumMapper.updatetForum(map);
	}

	@Override
	public void deleteForum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		boardForumMapper.deleteForum(map);
	}


}
