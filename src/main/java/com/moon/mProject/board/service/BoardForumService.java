package com.moon.mProject.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moon.mProject.board.VO.ForumVO;

public interface BoardForumService {

	public int selectMaxIdx();

	public void insertForum(ForumVO forumVo);

	public List<ForumVO> selectForumList(HashMap<String, Object> map);

	public int selectForumTotal();

	public List<ForumVO> selectForumDetail(int idx);

	public void updatetForum(Map<String, Object> map);

	public void deleteForum(Map<String, Object> map);



}
