package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Menu画面（ログイン直後画面）に関するコントローラー
 */
@Controller
public class MenuController {

	/**
	 * Menu画面描画
	 */
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String login() {
		return "menu";
	}
}
