package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entity.ShopEntity;
import com.example.demo.form.MenuForm;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ShopRepository;
import com.example.demo.service.ShopService;

@Controller
@SessionAttributes(types = MenuForm.class)

public class MenuController {
	
	@Autowired 
	ShopRepository shpRepository;
	@Autowired
	CategoryRepository ctgryRepository;
	@Autowired
	ItemRepository itmRepository;
	
	/**
	 * Formオブジェクトを初期化して返却する（この方法で良いのかわかりません・・・）
	 * したいこと：他の画面でも使用できるように、ログイン名をセットしたい。
	 * @return Formオブジェクト
	 */
	@ModelAttribute("menuForm")
	public MenuForm createMenuForm() {
		MenuForm menuForm = new MenuForm();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String loginName = user.getUsername();//get logged in username
		menuForm.setName(loginName);
		return menuForm;
	}
	
	/**
	 * 購入品登録画面に遷移す
	 * @param  menuForm Formオブジェクト
	 * @return 購入品登録画面へのパス
	 */
	@GetMapping("/regist")
	public String resisterItem(MenuForm menuForm, Model model) {
		
		//店舗　まず、選択肢を直接書いてみる→将来的にDBからの値
//		Map<String,String> selectMap = new LinkedHashMap<String,String>();
//		selectMap.put("key_A", "選択肢１");
//		selectMap.put("key_B", "選択肢2");
//		model.addAttribute("selectItem", selectMap);
		model.addAttribute("shop", shpRepository.findAll());
		model.addAttribute("category", ctgryRepository.findAll());
		model.addAttribute("item", itmRepository.findAll());
		
		return "resisterItem";
	}
}
