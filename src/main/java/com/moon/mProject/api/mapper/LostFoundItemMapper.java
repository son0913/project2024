package com.moon.mProject.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.moon.mProject.api.vo.LostFoundItemVO;

@Mapper
public interface LostFoundItemMapper {
	public void insertLostFoundItem(Map<String, Object> map);

	public void deleteLostFoundItem();

	public List<LostFoundItemVO> selectLostFoundItem();
}
