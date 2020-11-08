//package com.example.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dao.LoginDao;
//import com.example.demo.dto.LoginDto;
//
//@Service
//public class DemoUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private LoginDao userBhv; 
//
//    @Autowired
//    private MessageSource messageSource;
//
//	@Override
//	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//
//		// 入力値が空の場合もあるため、予めチェックしておく。
//		if (userId == null || userId.isEmpty()) {
//			// UsernameNotFoundExceptionにメッセージを渡しても画面に反映されないので、
//			// ここでは適当に空文字を入れておく
//			throw new UsernameNotFoundException("");
//		}
//
//		try {
//			// 渡されたIDをキーにユーザ情報取得
//			LoginDto user = userBhv.findUser(userId);
//			// DBから取得したユーザー情報を返却する
//			return (UserDetails) user;
//
//		} catch (Exception e) {
//			//userIdをキーに何も見つかなければ例外を発生
//			throw new UsernameNotFoundException("");
//		}
//	}
//
//
//}
