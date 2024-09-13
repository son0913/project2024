package com.moon.mProject.board.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.moon.mProject.board.VO.ForumVO;

@Mapper
public interface BoardForumMapper {

	public int selectMaxIdx();
	
	public void insertForum(ForumVO forumVo);

	public List<ForumVO> selectForumList(HashMap<String, Object> map);

	public int selectForumTotal();

	public List<ForumVO> selectForumDetail(int idx);

	public void updatetForum(Map<String, Object> map);

	public void deleteForum(Map<String, Object> map);


}
