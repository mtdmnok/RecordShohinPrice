package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ResisterItemRepository;
import com.example.demo.repository.ShopRepository;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ParseException;

@Controller
public class MasterController {
	
	@Autowired
	ResisterItemRepository repository;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ItemRepository itemRepository;

	/**
	 * マスタ画面
	 */
	@GetMapping("/master")
	public String master(Model model) {
		model.addAttribute("shop", shopRepository.findAll());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("item", itemRepository.findAll());
		return "master";
	}
	
	/**
	 * マスタ情報検索
	 */
	@RequestMapping(value = "/resistMaster", method = RequestMethod.POST)
	public ModelAndView form(
			@RequestParam("shop_id") String shopId,
			@RequestParam("category_id") String categoryId,
			@RequestParam("item_id") String itemId,
			ModelAndView mav) throws ParseException {
	
		
		
		return new ModelAndView("");
	}
			
}
