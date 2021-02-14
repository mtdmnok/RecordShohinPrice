package com.example.demo.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.resisterItemEntity;
import com.example.demo.repository.resisterItemRepository;

@Controller
public class resisterItemController {

	@Autowired
	resisterItemRepository repository;
	
	@RequestMapping(value = "/resisterItem", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form(
			@ModelAttribute("formModel") resisterItemEntity resisterItemEntity,
			ModelAndView mav) throws ParseException {
		
		Calendar calendar = Calendar.getInstance();
        //作成日
		resisterItemEntity.setCreated_at(calendar.getTime());
		//更新日			
		resisterItemEntity.setUpdated_at(calendar.getTime());
		
		repository.saveAndFlush(resisterItemEntity);
		return new ModelAndView("redirect:/");
	}

	private void If(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
