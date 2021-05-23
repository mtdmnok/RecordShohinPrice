package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * http://localhost:8080/ にアクセスした際に呼び出されるコントローラーです。
	 * ここはログイン画面を表示するという要件だと思いますので、記載の通り return "login" で OKですね。
	 *
	 * 下のメソッド名と被っているので、名前を変えました
	 * @return
	 */
	@RequestMapping("/")
	public String disp_loginoform() {
		return "login";
	}
	/**
	 * WebSecurityConfig にあるようにログインが成功すると http://localhost:8080/menu 遷移します。その時に呼び出されるのがこのコントローラーです。
	 * @param modelMap
	 * @param ID
	 * @param password
	 * @return
	 */
	//入力したIDとパスワードを取得
//	@RequestMapping(value="/menu", method=RequestMethod.GET)
//	public String login() {
//		return "menu";
//	}
}
