package com.moon.mProject.api.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moon.mProject.api.mapper.LostFoundItemMapper;
import com.moon.mProject.api.service.LostFoundItemService;
import com.moon.mProject.api.vo.LostFoundItemVO;

@Service
public class LostFoundItemServiceImpl implements LostFoundItemService{

	@Autowired
	LostFoundItemMapper mapper;

	@Override
	@Transactional
	public void insertLostFoundItem(Map<String, Object> map) {
		mapper.insertLostFoundItem(map);
	}

	@Override
	@Transactional
	public void deleteLostFoundItem() {
		mapper.deleteLostFoundItem();
		
	}

	@Override
	public List<LostFoundItemVO> selectLostFoundItem() {
		// TODO Auto-generated method stub
		return mapper.selectLostFoundItem();
	}


}
