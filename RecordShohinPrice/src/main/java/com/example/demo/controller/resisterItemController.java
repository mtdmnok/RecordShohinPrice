package com.example.demo.controller;



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
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form(
			@ModelAttribute("formModel") resisterItemEntity resisterItemEntity,
			ModelAndView mav) {
		repository.saveAndFlush(resisterItemEntity);
		return new ModelAndView("redirect:/");
	}
}
