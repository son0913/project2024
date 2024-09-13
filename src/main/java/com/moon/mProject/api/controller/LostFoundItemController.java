package com.moon.mProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moon.mProject.api.service.LostFoundItemService;
import com.moon.mProject.api.vo.LostFoundItemVO;

@RestController
@RequestMapping("/api")
public class LostFoundItemController {

	@Autowired
	private LostFoundItemService service;
	
	@GetMapping("/LostFoundItem")
	public ModelAndView ViewLostFoundItem() {
		
		ModelAndView model = new ModelAndView("/api/LostFoundItem");
		return model;
	}
	
	@GetMapping("/selectLostFoundItem")
	public List<LostFoundItemVO> SelectLostFoundItem() {
		List<LostFoundItemVO> lstFndItm = service.selectLostFoundItem();
		return lstFndItm;
	}
}
