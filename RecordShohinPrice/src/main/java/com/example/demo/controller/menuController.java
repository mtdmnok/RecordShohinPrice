package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

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

import com.example.demo.form.menuForm;

@Controller
@SessionAttributes(types = menuForm.class)

public class menuController {
	
	/**
	 * Formオブジェクトを初期化して返却する（この方法で良いのかわかりません・・・）
	 * したいこと：他の画面でも使用できるように、ログイン名をセットしたい。
	 * @return Formオブジェクト
	 */
	@ModelAttribute("menuForm")
	public menuForm createMenuForm() {
		//ここで、ログイン名をセットしたいがエラーとなってしまいます。
		menuForm menuForm = new menuForm();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String loginName = user.getUsername();//get logged in username
		menuForm.setName(loginName);
		return menuForm;
	}
	
	/**
	 * 購入品登録画面に遷移する
	 * @param  menuForm Formオブジェクト
	 * @return 購入品登録画面へのパス
	 */
	@GetMapping("/regist")
	public String resisterItem(menuForm menuForm, Model model) {
		
		//まず、選択肢を直接書いてみる→将来的にDBからの値
		Map<String,String> selectMap = new LinkedHashMap<String,String>();
		selectMap.put("key_A", "選択肢１");
		selectMap.put("key_B", "選択肢2");
		model.addAttribute(selectMap);
		
		return "resisterItem";
	}
}
