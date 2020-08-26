package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginDto;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDao loginDao;

	@RequestMapping("/")
	public List<LoginDto> login() {
		 
		
		//DBからユーザーマスタの情報を取得する
		List<LoginDto> loginInfoList = loginDao.findAll();
		
		return login();
		
	}
	
	//入力したIDとパスワードを取得
	@RequestMapping("login")
	public String login(ModelMap modelMap, @RequestParam("ID") String ID, @RequestParam("password") String password) {
		//判定フラグ
		Boolean loginFlg = false;
		//名前取得用変数
		String name = "";
		
		
		//取得したログインリストを検索して存在の有無を確認する？
				for(LoginDto LoginInfo : login()) {
					if (LoginInfo.getUser_id() == ID) {
							if (LoginInfo.getPassword() == password) {
								//ログイン判定OK
								loginFlg = true;
								name = LoginInfo.getUser_name();
								//ログイン情報が見つかったら、for文を抜ける
							}	break;
					}
				}
		
				//HTML（フロント）に渡す
		modelMap.addAttribute("loginFlg", loginFlg);
		modelMap.addAttribute("name", name);
		
		//表示するHTMLを選択
		if(loginFlg) {
		return "menu";
		} else {
			return "login";
		}
	}
}
