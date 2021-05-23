package com.example.demo.controller;



import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ResisterItemEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ResisterItemRepository;
import com.example.demo.repository.ShopRepository;

@Controller
public class ResisterItemController {

	@Autowired
	ResisterItemRepository repository;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ItemRepository itemRepository;
	
	/**
	 * 購入品登録画面
	 */
	@GetMapping("/regist")
	public String resisterItem(Model model) {
		model.addAttribute("shop", shopRepository.findAll());
		model.addAttribute("category", categoryRepository.findAll());
		model.addAttribute("item", itemRepository.findAll());

		return "registerItem";
	}
	
	
	
	/**
	 * 購入商品登録
	 */
	@RequestMapping(value = "/resisterItem", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form(
			@RequestParam("purchace_date") String dateString,
			@RequestParam("shop_id") String shopId,
			@RequestParam("category_id") String categoryId,
			@RequestParam("item_id") String itemId,
			@RequestParam("price") Integer price,
			ModelAndView mav) throws ParseException {
		
		//DBに保存するためのエンティティのインスタンス生成
		ResisterItemEntity entity = new ResisterItemEntity();
		
		//ユーザーid
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		entity.setUser_id(user.getUsername());
		//日付
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		entity.setPurchase_date(sdFormat.parse(dateString));
		//店舗
		entity.setShop_id(shopId);
		//品目
		entity.setCategory_id(categoryId);
		//商品名
		entity.setItem_id(itemId);
		//価格
		entity.setPrice(price);
		
		Calendar calendar = Calendar.getInstance();
        //作成日
		entity.setCreatedAt(calendar.getTime());
		//更新日			
		entity.setUpdatedAt(calendar.getTime());
		
		try {
		
		repository.saveAndFlush(entity);
		//return new ModelAndView("redirect:/");
		} catch (Exception e) {
			return new ModelAndView("registDB_NG");
		} 
		return new ModelAndView("registDB_OK");
		
		
	}
	
	/**
	 * メニュー画面に遷移する
	 */
	@RequestMapping(path = "menu", method = RequestMethod.POST)
	public String moveToMenu() {
				return "menu";
	}

}
