package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	/**
	 * ログイン画面（TOP画面描画）に関するコントローラー
	 * @return
	 */
	@RequestMapping("/")
	public String disp_loginoform() {
		return "login";
	}
}
