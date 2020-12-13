package com.example.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/menu")
	public String resisterItem(menuForm menuForm) {
		return "resisterItem";
	}
}
