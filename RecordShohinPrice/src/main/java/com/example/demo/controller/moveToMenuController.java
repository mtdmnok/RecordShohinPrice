//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.dto.LoginDto;
//
//@Controller
//public class moveToMenuController {
//	//ここでやりたいこと
//	//（1）画面から入力した値を受け取る　
//		//@PostMapping、RequestParamで取得？
//	//（2）受け取った値をDBの値と比較する
//		//LoginDto型のリストから該当のデータがあるかループで探す？
//		//LoginControllで取得したDBデータを使用する？
//		//そもそも、LoginControllでDB取得する意味はある？
//	//（3）結果によって遷移先を変える（OK→メニュー　NG→ログイン画面）
//		//return "login" もしくは　return "menu"となる？
//	
//	
////	//判定フラグ
//	Boolean loginFlg = false;
////	//名前取得用変数
//	String name = "";
//	
//	//(1)画面からの値を取得
//	@PostMapping("login")
//	String login(ModelMap modelMap, @RequestParam("ID") String ID, @RequestParam("password") String password) {
//	
//		
//		//（2）受け取った値をDBの値と比較
//		//比較するデータはどうやってとってくるか分かりません
//		List<LoginDto> loginInfoList //　　= loginDao.findAll();？？
//		
//		//画面からのデータとの比較
//		//取得したログインリストを検索して存在の有無を確認する
//		for(LoginDto LoginInfo : loginList) {
//			if (LoginInfo.getUser_id() == ID) {
//					if (LoginInfo.getPassword() == password) {
//						//ログイン判定OK
//						loginFlg = true;
//						name = LoginInfo.getUser_name();
//						//ログイン情報が見つかったら、for文を抜ける
//					}	break;
//			}
//		}
//		
//		
//		//（3）遷移先を選択
//		if(loginFlg) {
//		return "menu";
//		} else {
//			return "login";
//		}
//	}
//}
