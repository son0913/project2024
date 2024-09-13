package com.moon.mProject.api.service;

import java.util.List;
import java.util.Map;

import com.moon.mProject.api.vo.LostFoundItemVO;

public interface LostFoundItemService {
	public void insertLostFoundItem(Map<String,Object> map);
	public void deleteLostFoundItem();
	public List<LostFoundItemVO> selectLostFoundItem();
}
